/*
* Implementation of a simple single pointed linked list.
* Every node has data and a pointer which points at next node. Tail's pointer points at null.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Lists;

public class SinglyLinkedList implements LinkedList {


    // Model Node.
    private class Node {

        // Model data. Data can be anything Strings, Integers, Floats and so on
        // More fields can be added based upon organisational needs.
        private Object data;
        // Pointer to the next node.
        private Node next;

        // Constructor.
        Node(Object obj, Node next) {
            this.data = obj;
            this.next = next;
        }

    }
    

    // First node in the list.
    private Node head;
    // Last node in the list.
    private Node tail;
    // Length of the list. (Total number of nodes in the list)
    private int len;

    // Constructor. Initialises the list.
    public SinglyLinkedList() {
        this.head = this.tail = new Node(null, null); // Not mandotary.
        this.len = 0;
    }

    // Add first node whose pointer points at null.
    private int addFirst(Object obj) {
        try {
            // Sets both head and tail to this node.
            this.head = this.tail = new Node(obj, null);
            // Increase the length variable.
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add node at the start of the list. O(1)
    public int addAtStart(Object obj) {
        try {
            // In case list does not have any nodes yet.
            if (this.len == 0)
                return addFirst(obj);
            // Create new node whose pointer points at the head node and
            // then set head variable to the newly created node.
            this.head = new Node(obj, this.head);
            // Increment length.
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
    
    // Add a node at the end. O(1)
    public int addAtEnd(Object obj) {
        try {
            // If no nodes present yet.
            if (this.len == 0)
                return addFirst(obj);

            // Create a node, set tail's pointer to that node and
            // set tail variable to that node. O(1).
            this.tail = this.tail.next = new Node(obj, null);

            // Iterate over the whole list if tail isn't present. O(n) (Inefficient).
            /*
            Node current = this.head;

            for (int i = 0; i < this.len-1; i++)
                current = current.next;
                current.next = new Node(obj, null);
            */

            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Insert node at particular index. Supports negative indexing and overflowing index. O(n)
    public int insertAt(Object obj, int index) {
        try {
            if (index < 0 && index * (-1) < this.len)
                // Algorithm for adjusting negative indices.
                index = this.len - index * (-1);
            // If negative index overflows the length.
            else if (index < 0)
                return 1;
            
            // Checks to divert to O(1) implementations.
            if (index == 0)
                return addAtStart(obj);
            else if (index >= this.len-1)
                return addAtEnd(obj);
            // O(n) implementation.
            else {
                Node current = this.head;
                Node previous = null;
                // Iterate over the list until node just before index is reached.
                for (int i = 0; i < index; i++) {
                    previous = current;
                    current = current.next;   
                }
                // Create new node who points at node situated at index then
                // set current element's pointer to this newly created node.
                previous.next = new Node(obj, current);
                this.len++;
            }
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // Returns node data at specifed index. Support for negative indices and overflowing indexes. O(n)
    public Object getAt(int index) {
        try {
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);

            Node current = this.head;
            // Iterates over the list and returns the data.
            for (int i = 0; i < index; i++)
                current = current.next;
            return current.data;
        } catch (Exception e) {
            return null;
        }
    }

    // Remove node at an index. Does NOT support negative indexes and overflowing. O(n)
    public int removeAt(int index) {
        try {
            // Exit if index is incorrect.
            if (index >= this.len || index < 0)
                return 1;

            /* Support for negative indices.
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);
            else if (index < 0)
                return 1;
            */

            Node current = this.head;
            Node previous = null;

            // Iterate.
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }

            // Set previous node's pointer to current node's pointer and set data field(s) to null.
            previous.next = current.next;
            current.data = null;
            // Decrement.
            this.len--;

            // In case nodes removed were first or last nodes in the list.
            if (index == 0) 
                this.head = current.next;
            else if (index == this.len)
                this.tail = previous;
                
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // TODO Tests.
    // Delete list. O(n)
    public int clear() {
        try {
            Node current = this.head;
            // Iterate over the list while setting data fields to null.
            while (current != null) {
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

    // Return true if list is empty otherwise false. O(1)
    public boolean isEmpty() {
        return this.head == null && this.len == 0;
    }

    // Return length of the list. 0 if its empty. O(1)
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
            while (current != null) {
                // Add quotes to signify string object.
                if (current.data instanceof String)
                    result += "\"" + current.data + "\", ";
                else
                    result += current.data + ", ";
                current = current.next;
            }
            // Remove last 2 unnecessary characters.
            return result.substring(0, result.length()-2) + "]";
        } catch (Exception e) {
            return null;
        }
    }


    // Deprecated. (Was being used for debugging)
    @Deprecated
    public int printList() {
        try {
            if (this.len == 0)
                System.out.println("\nThe list is empty.");
            else {
                System.out.println("\nThe elements in the list are: ");
                Node current = this.head;
                while(current != null) {
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

    /*
    @Deprecated
    public Object pop(int index) {
        Object obj = getAt(index);
        removeAt(index);
        return obj;
    }
    */

    // Tests.
    public static void main(String[] args) {
        LinkedList ll = new SinglyLinkedList();
        ll.addAtStart(400);
        ll.addAtStart(300);
        ll.addAtStart(200);
        ll.addAtStart(100);
        System.out.println(ll.getAt(0));
        System.out.println(ll.getAt(1));
        System.out.println(ll.getAt(2));
        System.out.println(ll.getAt(3));
        System.out.println(ll);
        ll.removeAt(3);
        System.out.println(ll);
        ll.clear();
        System.out.println(ll);
        System.out.println(ll.isEmpty());
    }


}