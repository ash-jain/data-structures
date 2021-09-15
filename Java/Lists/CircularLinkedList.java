/*
* Implementation of Circular linked list.
* Each node has a pointer which points to the next node with tail (last) node's pointer pointing at head (first) node.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Lists;

public class CircularLinkedList implements LinkedList {


    // Node.
    private class Node {

        // Model data. Data can be anything Strings, Integers, Floats and so on
        // More fields can be added based upon organizational needs.
        private Object data;
        // Pointer to next node.
        private Node next;

        // Constructor.
        Node(Object obj, Node next) {
            this.data = obj;
            this.next = next;
        }

    }

    // First node in the list.
    private Node head;
    // Length of the list. (Total number of nodes in the list)
    private int len;

    // Constructor. Initialize the list.
    public CircularLinkedList() {
        this.head = new Node(null, null); // Unnecessary.
        this.len = 0;
    }

    // Add first node whose pointers point at null. O(1)
    private int addFirst(Object obj) {
        try {
            // Set head to this node.
            this.head = new Node(obj, null);
            // Increment length variable.
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add element at the start of the list. O(1)
    public int addAtStart(Object obj) {
        try {
            // In case list does not have any nodes yet.
            if (this.isEmpty())
                return addFirst(obj);
            // Create new node whose pointer points at current head node
            // and then set head to this pointer.
            this.head = new Node(obj, this.head);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add at the end of the list. O(n)
    public int addAtEnd(Object obj) {
        try {
            // If list is empty.
            if (this.isEmpty())
                return addFirst(obj);

            Node current = this.head;
            // Iterate over until last node is reached.
            for (int i = 0; i < this.len; i++)
                current = current.next;
            // Create a new node whose pointer points at head,
            // set the last node's pointer to this node.
            current.next = new Node(obj, this.head);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
        
    // Insert at particular index. Supports negative and overflowing indices. O(n)
    public int insertAt(Object obj, int index) {
        try {
            if (index < 0 && index * (-1) < this.len)
                // Algorithm for adjusting negative indices.
                index = this.len - index * (-1);
            // If negative index overflows.
            else if (index < 0)
                return 1;

            // Check to divert to O(1) implementations.
            if (index == 0)
                return addAtStart(obj);
            else if (index >= this.len-1)
                return addAtEnd(obj);

            Node current = this.head;
            Node previous = null;
            // Iterate over until node just before index is reached.
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            // Create new node whose pointer points at node at index and
            // the set previous node's pointer to this node.
            previous.next = new Node(obj, current);
            this.len++;
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // Returns element by given index. Supports negative indices and overflowing. O(n)
    public Object getAt(int index) {
        try {
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);
            else if (index < 0)
                return null;
            // If index is greater than length.
            else if (index >= this.len )
                return this.len-1;

            Node current = this.head;
            for (int i = 0; i < index; i++)
                current = current.next;
            return current.data;
        } catch (Exception e) {
            return null;
        }
    }
    
    // Remove node at specified index. Does NOT support negative indexes and overflowing. O(n)
    public int removeAt(int index) {
        try {
            // Terminate for incorrect indexes.
            if (index >= this.len || index < 0)
                return 1;

            /* Support for negative indices.
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);
            else if (index < 0)
                return 1;
            */

            // TODO check, run tests.
            Node current = this.head;
            Node previous = null;

            // Iterate.
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }

            // Set previous node's next pointer to next node.
            previous.next = current.next;
            current.data = null;
            // Decrement.
            this.len--;

            // In case node removed was first node in the list.
            if (index == 0)
                this.head = current.next;

            return 0;
        } catch (Exception e) {
            return -1; 
        }
    }

    // Delete list.
    public int clear() {
        try {
            Node current = this.head;
            // Iterate over the list while setting data fields to null.
            // TODO Run tests.
            for (int i = 0; i <= this.len; i++) {
                current.data = null;
                current = current.next;
            }
            // Set head to null and call in Java garbage collector.
            this.head = null;
            System.gc();
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if list is empty otherwise false.
    public boolean isEmpty() {
        return this.head == null && this.head.data == null && this.head.next == null && this.len == 0;
    }

    // Return length of the list. 0 if its empty.
    public int getLength() {
        return this.len;
    }

    // Stringifies the object.
    @Override
    public String toString() {
        try {
            // If list is empty.
            if (this.isEmpty())
                return "[]";
            Node current = this.head;
            String result = "[";
            for (int i = 0; i < this.len; i++) {
                // Add quotes if object is a string.
                if (current.data instanceof String)
                    result += "\"" + current.data + "\", ";
                else
                    result += current.data + ", ";
                current = current.next;
            }
            // Remove unnecessary whitespace and extra comma.
            result = result.substring(0, result.length()-2) + "]";
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    // Deprecated. (Was being used for debugging);
    @Deprecated
    public int printList() {
        try {
            if (this.len == 0)
                System.out.println("\nThe list is empty.");
            else {
                System.out.println("\nThe elements in the list are: ");
                Node current = this.head;
                for (int i = 0; i < this.len ; i++) {
                    System.out.println(current.data);
                    current = current.next;
                }
                System.out.println();
            }
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
    
    // Tests.
    public static void main(String[] args) {
        LinkedList cll = new CircularLinkedList();
        cll.addAtStart(300);
        cll.addAtStart(200);
        cll.addAtStart(100);
        cll.addAtStart("400");
        System.out.println(cll);
    }


}