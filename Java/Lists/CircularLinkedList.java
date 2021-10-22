/*
* Implementation of Circular linked list.
* Each node has a pointer which points to the next node with tail (last) node's pointer pointing at head (first) node.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Lists;

public class CircularLinkedList implements LinkedList {

    // Node prototype.
    private class Node {

        // Model data. Data can be any object
        // More fields can be added as per requirements.
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
    // Length of the list. (Total number of nodes in the list)
    private int len;

    // Initialize the list.
    public CircularLinkedList() {
        this.head = new Node(null, null); // Unnecessary, better practice.
        this.len = 0;
    }

    // Add first node when the list is empty. O(1)
    private int addFirst(Object obj) {
        try {
            // Create a new node whose pointer points at null and set head to it.
            this.head = new Node(obj, null);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add node at the start of the list. O(1)
    public int addAtStart(Object obj) {
        try {
            if (this.isEmpty())
                return addFirst(obj);
            // Create new node whose pointer points at the head node and
            // then set head itself to this newly created node.
            this.head = new Node(obj, this.head);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add node at the end of the list. O(n)
    public int addAtEnd(Object obj) {
        try {
            if (this.isEmpty())
                return addFirst(obj);

            // Iterate over until last node is reached.
            Node current = this.head;
            for (int i = 0; i < this.len; i++)
                current = current.next;
            // Create new node and set the pointer of the last node to it.
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
            // Adjust for negative index.
            if (index < 0 && index * (-1) < this.len)
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
            // the set previous node's pointer to this newly created node.
            previous.next = new Node(obj, current);
            this.len++;
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // Return node data at a specified index. Supports negative indices and overflowing. O(n)
    public Object getAt(int index) {
        try {
            // Adjust for negative index.
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);
            // If negative index overflows.
            else if (index < 0)
                return null;

            else if (index > this.len-1)
                index = this.len-1;

            Node current = this.head;
            // Iterate over the list until index is reached and return the data.
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
            // Check for invalid index.
            if (index >= this.len || index < 0)
                return 1;
            // If there's only one element in the list.
            else if (this.len == 1) {
                this.head.data = null;
                this.head = new Node(null, null);
            }
            else if (index == 0) {
                this.head.data = null;
                this.head = this.head.next;
            }
            else {
                Node current = this.head;
                Node previous = null;
                // Iterate over the list until node at index is reached.
                for (int i = 0; i < index; i++) {
                    previous = current;
                    current = current.next;
                }
                // Nullify the data and set previous node's next pointer to the next node.
                current.data = null;
                previous.next = current.next;
            }

            this.len--;
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
            for (int i = 0; i <= this.len; i++) {
                current.data = null;
                current = current.next;
            }
            // Set head to empty node and call in Java garbage collector.
            this.head = new Node(null, null);
            System.gc();
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if list is empty, false otherwise. O(1)
    public boolean isEmpty() {
        return this.head.data == null && this.head.next == null && this.len == 0;
    }

    // Return length of the list. O(1)
    public int getLength() {
        return this.len;
    }

    // Stringifies the linked list data. O(n)
    @Override
    public String toString() {
        try {
            if (this.isEmpty())
                return "[]\n";

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
            // Remove 2 unnecessary characters from the last node.
            return result.substring(0, result.length()-2) + "]\n";
        } catch (Exception e) {
            return null;
        }
    }

    // Print the linked list data.
    @Deprecated
    public int printList() {
        try {
            if (this.isEmpty())
                System.out.println("THE LIST IS EMPTY:\n[]\n");
            else {
                System.out.print("\nDATA IN LINKED LIST IS: \n[");
                Node current = this.head;
                for (int i = 0; i < this.len ; i++) {
                    System.out.print(current.data);
                    if (i != this.len-1)
                        System.out.print(", ");
                    current = current.next;
                }
                System.out.println("]\n");
            }
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }


    // Tests.
    public static void main(String[] args) {
    }

}