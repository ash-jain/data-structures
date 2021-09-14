/*
* Implementation of simple linked queue using linear linked list to store the data.
* Each node has two pointers - one to previous node and one to next node.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Queues;

public class LinkedQueue implements Queue {

    // Node.
    private class Node {

        // Model data. Data can be any object
        // More fields can be also added as per requirements.
        private Object data;
        // Pointers to previous and next nodes.
        private Node prev, next;

        // Constructor.
        Node (Object obj, Node prev, Node next) {
            this.data = obj;
            this.prev = prev;
            this.next = next;
        }

    }

    // First node in the queue.
    private Node head;
    // Last node in the queue.
    private Node tail;
    // Length of the queue. (Total number of nodes in the list)
    private int len;

    // Initialize the list.
    public LinkedQueue() {
        // Both not necessary just better practice.
        this.head = this.tail = new Node(null, null, null);
        this.len = 0;
    }

    // Add first node when the list is empty, with its pointers pointing at null. O(1)
    private int addFirst(Object obj) {
        try {
            // Create new node whose both pointers point at null and set tail and head both to it.
            this.head = this.tail = new Node(obj, null, null);
            // Increment length variable.
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add element at the end of the queue. O(1)
    public int push(Object obj) {
        try {
            // If queue is empty
            if (this.isEmpty())
                return this.addFirst(obj);
            // Create new node whose previous pointer points at current tail.
            // Set this node to pointer of tail and set tail variable to this node.
            this.tail = this.tail.next = new Node(obj, this.tail, null);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return first element in the queue. O(1)
    public Object peek() {
        try {
            return this.head.data;
        } catch (Exception e) {
            return null;
        }
    }

    // Return and remove next element in the queue. O(1)
    public Object pop() {
        try {
            // Copy over data from node to be removed.
            Object data = this.head.data;
            // Delete the data at head and set head to next element with its
            // previous pointers set to null as it is now first element in the queue.
            this.head.data = null;
            this.head = this.head.next;
            this.head.prev = null;
            this.len--;
            return data;
        } catch (Exception e) {
            return null;
        }
    }

    // Remove an element at a particular index. Does NOT support negative indexes or overflowing. O(n)
    public int remove(int index) {
        try {
            // Check for invalid indexes.
            if (index < 0 || index >= this.len)
                return 1;
            else if (index == 0) {
                this.head.data = null;
                this.head = this.head.next;
                this.head.prev = null;
            }
            else if (index == this.len-1) {
                this.tail.data = null;
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
            else {
                // Iterate until element at index is reached.
                Node current = this.head;
                for (int i = 0; i < index; i++)
                    current = current.next;

                // Nullify the data and modify pointers of previous and next
                // elements such that they point to each other.
                current.data = null;
                current.prev.next = current.next;
                current.next.prev = current.prev;
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
            // Set head and tails to null and call in Java garbage collector.
            this.head = this.tail = null;
            System.gc();
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if list is empty, false otherwise.
    public boolean isEmpty() {
        return this.len == 0 && this.head.data == null && this.tail.data == null;
    }

    // Return length of the list.
    public int getLength() {
        return this.len;
    }

    // Stringify the queue data.
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

    @Deprecated
    public int printQueue() {
        try {
            if (this.isEmpty())
                System.out.println("QUEUE IS EMPTY.");
            else {
                Node current = this.head;
                System.out.println("\nCURRENT QUEUE IS: ");
                while (current.data != null)
                    System.out.print(" " + current.data + " |" );
                    current = current.next;
            }
            System.out.println("\n");
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }


    // Tests.
    public static void main(String[] args) {
    }

}
