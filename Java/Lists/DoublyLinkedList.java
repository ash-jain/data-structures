/*
* Implementation of dually pointed linked list.
* Each node has data and two pointers who point at a node before and ahead of it.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Lists;

public class DoublyLinkedList implements LinkedList {

    // Node prototype.
    private class Node {

        // Model data. Data can be any object
        // More fields or custom objects can also be added as per requirements.
        private Object data;
        // Pointers to the next and previous nodes.
        private Node prev, next;

        // Constructor.
        Node(Object obj, Node prev, Node next) {
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
    public int len;

    // Initialize the list.
    public DoublyLinkedList() {
        // Not necessary, just better practice.
        this.head = this.tail = new Node(null, null, null);
        this.len = 0;
    }

    // Add first node when the list is empty. O(1)
    private int addFirst(Object obj) {
        try {
            // Create new node whose pointers point at null and set tail and head both to it.
            this.head = this.tail = new Node(obj, null, null);
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
            // Create new node whose next pointer points at the head node and
            // then set head itself to this newly created node.
            this.head = new Node(obj, null, this.head);
            // Point former head's previous pointer to new list head.
            this.head.next.prev = this.head;
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add node at the end of the list. O(1)
    public int addAtEnd(Object obj) {
        try {
            if (this.isEmpty())
                return addFirst(obj);

            // Create new node whose previous pointer points at current tail,
            // Set current tail's next pointer to that node and
            // set tail itself to this newly created node.
            this.tail = this.tail.next = new Node(obj, this.tail, null);

            /* If the tail is not set.
            Node current = this.head;
            // Iterate over the whole list. O(n) (Inefficient)
            while(current.next != null)
                current = current.next;
            current.next = new Node(obj, current, null);
            */

            this.len++;
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // Add node at a particular index. Supports negative or overflowing indexes. O(n)
    public int insertAt(Object obj, int index) {
        try {
            // Adjust for negative index.
            if (index < 0 && index * (-1) <= this.len)
                index = this.len - index * (-1);
            // If negative index overflows.
            else if (index < 0)
                return 1;

            // Check to divert to O(1) implementations.
            if (index == 0)
                return addAtStart(obj);
            else if (index >= this.len-1)
                return addAtEnd(obj);
            // Optimization. Check for index being closer from tail or head and then iterate from that end. O(n/2) -> O(n).
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

                // Iterate from tail until element just before index is reached.
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

    // Return node data at a specified index. Supports negative or overflowing indexes. O(n)
    public Object getAt(int index) {
        try {
            // Adjust for negative index.
            if (index < 0 && index * (-1) <= this.len)
                index = this.len - index * (-1);
            // If negative index overflows.
            else if (index < 0)
                return null;

            if (index > this.len-1)
                index = this.len-1;

            Node current = this.head;
            // Check whether index is closer from head or tail and iterate from that end. O(n/2) -> O(n)
            if (index <= this.len/2 + 1) {
                for (int i = 0; i < index; i++)
                    current = current.next;
                return current.data;
            } else {
                for (int i = this.len-1; i > index; i--)
                    current = current.next;
                return current.data;
            }
        } catch (Exception e) {
            return null;
        }
    }

    // Remove node at specified index. Does NOT support negative or overflowing indexes. O(n)
    public int removeAt(int index) {
        try {
            // Check for invalid index
            if (index < 0 || index >= this.len)
                return 1;
            // If there's only one element in the list.
            else if (this.len == 1) {
                this.head.data = null;
                this.head = this.tail = new Node(null, null, null);
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
                // Nullify the data and modify pointers of previous and next
                // nodes such that they point to each other.
                current.data = null;
                previous.next = current.next;
                current.next.prev = previous;

                if (index == this.len-1)
                    this.tail = current;
            }

            this.len--;
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // Delete list. O(n)
    public int clear() {
        try {
            Node current = this.head;
            // Iterate over the list while setting data fields to null.
            while (current != null) {
                current.data = null;
                current = current.next;
            }
            // Set head and tail to empty node and call in Java garbage collector.
            this.head = this.tail = new Node(null, null, null);
            System.gc();
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if list is empty, false otherwise. O(1)
    public boolean isEmpty() {
        return this.head.data == null && this.tail.data == null && this.len == 0;
    }

    // Return length of the list. O(1)
    public int getLength() {
        return this.len;
    }

    // Stringify the linked list data. O(n)
    @Override
    public String toString() {
        try {
            if (this.isEmpty())
                return "[]\n";

            Node current = this.head;
            String result = "[";
            while (current != null) {
                // Add quotes if the object is a string.
                if (current.data instanceof String)
                    result += "\"" + current.data + "\", ";
                else 
                    result += current.data + ", ";
                current = current.next;
            }
            // Remove 2 unnecessary characters from the last node.
            return result.substring(0, result.length()-2) + "]";
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
                while (current != null) {
                    System.out.println(current.data);
                    if (current.next != null)
                        System.out.println(", ");
                    current = current.next;
                }
                System.out.println("]\n");
            }
        return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    /*
    @Deprecated
    public void printListRev() {
        Node current = this.tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }
    */


    // Tests.
    public static void main(String[] args) {
    }

}
