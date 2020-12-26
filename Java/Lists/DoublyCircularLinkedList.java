/*
* Implementation of Dual pointed circular linked list.
* Each node points at a node before and ahead of it with last node's next pointer
* pointing at first and first node's previous pointer pointing at last.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Lists;

public class DoublyCircularLinkedList implements LinkedList {
    

    // Node.
    private class Node {

        // Model data. Data can be anything Strings, Integers, Floats and so on
        // More fields can be added based upon organisational needs.
        private Object data;
        // Pointers to the next and previous nodes.
        private Node prev, next;

        // Constructor.
        public Node (Object obj, Node prev, Node next) {
            this.data = obj;
            this.prev = prev;
            this.next = next;
        }

    }

    // First node in the list.
    private Node head;
    // Last node in the list.
    private Node tail;
    // Length of the list. (Total number of nodes in the list)
    private int len;

    // Constructor. Initialise the list.
    public DoublyCircularLinkedList() {
        this.head = this.tail = new Node(null, null, null); // Not mandotary.
        this.len = 0;
    }

    // Add first node whose pointers point at null. O(1)
    private int addFirst(Object obj) {
        try {
            // Set head and tail both to this node.
            this.head = this.tail = new Node(obj, null, null);
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
            // Create new node whose next pointer points at head node and
            // previous points at tail then set head to this node.
            this.head = new Node(obj, this.tail, this.head);
            // Point former head's pointer to this node.
            this.head.next.prev = this.head;
            // Point tail's next pointer to this node.
            this.tail.next = this.head;
            // this.head.prev.next = this.head; // Same as above.
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add at the end of the list. O(1)
    public int addAtEnd(Object obj) {
        try {
            // If list is empty.
            if (this.isEmpty())
                return addFirst(obj);
            // Create a node whose previous pointer points at tail and next points at head
            // of the list and then set it to tail node's next pointer and then set this newly
            // formed node as tail of the list.
            this.tail = this.tail.next = new Node(obj, this.tail, this.head);
            // Set former tail's next and head's prev as this newly formed node.
            this.tail.prev.next = this.tail;
            this.head.prev = this.tail;
            // this.tail.next.prev = this.tail; // Same as above.
            this.len++;
            return 0;
        } catch (Exception e) {
            return -1;
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
            // Check if index is closer from tail or head an iterate from that end. O(n/2) -> O(n).
            else if (index <= this.len/2 + 1) {
                Node current = this.head;

                // Iterate over until node just before index is reached.
                for (int i = 0; i < index; i++)
                    current = current.next;

                // Create new node whose pointers point at node before the index and node at the index,
                // and then set node before's (current's) next pointer to this node.
                current.next = new Node(obj, current, current.next);
                // Go to node formerly at index and set its previous pointer to newly created node.
                current.next.next.prev = current.next;  
            } else {
                Node current = this.tail;

                // Iterate form tail until element just before index is reached.
                for (int i = this.len; i > index; i--)
                    current = current.prev;

                // Create new node whose pointers point at node before the index and node at the index,
                // and then set node before's next pointer to this node.
                current.next = new Node(obj, current, current.next);
                // Go to node formerly at index and set its previous pointer to newly created node.
                current.next.next.prev = current.next;
            }
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return element by index number. Supports negative indices and overflowing returns last element. O(n)
    public Object getAt(int index) {
        try{
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);
            else if (index < 0)
                return null;
            // If index is greater than length.
            else if (index >= this.len)
                index = this.len-1;

            // Check whether index is closer from head or tail and iterate from that end. O(n/2) -> O(n)
            if (index <= this.len/2 + 1) {
                Node current = this.head;
                for (int i = 0; i < index; i++)
                    current = current.next;
                return current.data;
            } else {
                Node current = this.tail;
                for (int i = this.len-1; i > index; i--)
                    current = current.next;
                return current.data;
            }
        } catch (Exception e) {
            return null;
        }
    }

    // Remove node at specified index. Does NOT support negative indexes and overflowing. O(n)
    public int removeAt(int index) {
        try {
            // Terminate if index is incorrect
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

            // Iterate.
            for (int i = 0; i < index; i++)
                current = current.next;

            // Set previous node's next pointer to next node.
            current.prev.next = current.next;
            // Set next node's previous pointer to previous node.
            current.next.prev = current.prev;
            current.data = null;
            // Decrement.
            this.len--;

            // In case nodes removed were first or last nodes in the list.
            if (index == 0)
                this.head = current.next;
            else if (index == this.len)
                this.tail = current.prev;

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
            // TODO Run test.
            for (int i = 0; i <= this.len; i++) {
                current.data = null;
                current = current.next;
            }
            // Set head and tails to null and call in Java garbage collector.
            this.head = this.tail = null;
            System.gc();
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if list is empty otherwise false.
    public boolean isEmpty() {
        return this.head == null && this.tail == null && this.len == 0;
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
                // Add quotes if object is string.
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

    // For debugging only.
    @Deprecated
    public int printList() {
        try {
            if (this.isEmpty())
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
    public static void main (String[] args) {
        LinkedList dcll = new DoublyCircularLinkedList();
        dcll.addAtStart(300);
        dcll.addAtStart(200);
        dcll.addAtStart(100);
        dcll.addAtStart("400");
        System.out.println(dcll);
    }


}
