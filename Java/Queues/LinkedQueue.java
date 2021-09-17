/*
* Implementation of a simple linked queue using linear linked list to store the data.
* Each node has two pointers - one to the previous node and one to next node.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Queues;

public class LinkedQueue implements Queue {

    // Node prototype.
    private class Node {

        // Model data. Data can be any object
        // More fields or custom objects can also be added as per requirements.
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
    // Length of the queue. (Total number of nodes in the queue)
    private int len;

    // Initialize the list.
    public LinkedQueue() {
        // Not necessary to set just better practice.
        this.head = this.tail = new Node(null, null, null);
        this.len = 0;
    }

    // Add first node when the queue is empty. O(1)
    private int addFirst(Object obj) {
        try {
            // Create new node whose both pointers point at null and set tail and head both to it.
            this.head = this.tail = new Node(obj, null, null);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add object to (the end of) queue. O(1)
    public int push(Object obj) {
        try {
            if (this.isEmpty())
                return this.addFirst(obj);
            // Create new node whose previous pointer points at current tail.
            // Set this node to pointer of tail and the set tail to this node.
            this.tail = this.tail.next = new Node(obj, this.tail, null);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return next node in the queue. O(1)
    public Object peek() {
        try {
            return this.head.data;
        } catch (Exception e) {
            return null;
        }
    }

    // Remove and return next node in the queue. O(1)
    public Object pop() {
        try {
            // Copy over the data from node to be removed.
            Object data = this.head.data;
            // If there's only one element in the queue.
            if (this.len == 1) {
                this.head.data = null;
                this.head = this.tail = new Node(null, null, null);
                this.len--;
            }
            else if (!this.isEmpty()) {
                // Delete the data at head and set head to next node with its
                // previous pointers set to null as it is now first node in the queue.
                this.head.data = null;
                this.head = this.head.next;
                this.head.prev = null;
                this.len--;
            }

            return data;
        } catch (Exception e) {
            return null;
        }
    }

    // Remove a node at a particular index. Does NOT support negative or overflowing indexes. O(n)
    public int remove(int index) {
        try {
            // Check for invalid index.
            if (index < 0 || index >= this.len)
                return 1;
            // If there's only one element in the queue.
            else if (this.len == 1) {
                this.head.data = null;
                this.head = this.tail = new Node(null, null, null);
            }
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
                Node current = this.head;
                // Iterate until node at index is reached.
                for (int i = 0; i < index; i++)
                    current = current.next;

                // Nullify the data and modify pointers of previous and next
                // nodes such that they point to each other.
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
            // Set head and tail to empty node and call in Java garbage collector.
            this.head = this.tail = new Node(null, null, null);
            System.gc();
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if queue is empty, false otherwise. O(1)
    public boolean isEmpty() {
        return this.len == 0 && this.head.data == null && this.tail.data == null;
    }

    // Return length of the queue. O(1)
    public int getLength() {
        return this.len;
    }

    // Stringify the queue data. O(n)
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
            return result.substring(0, result.length()-2) + "]\n";
        } catch (Exception e) {
            return null;
        }
    }

    // Print the queue data.
    @Deprecated
    public int printQueue() {
        try {
            if (this.isEmpty())
                System.out.println("QUEUE IS EMPTY:\n[]\n");
            else {
                System.out.print("\nCURRENT QUEUE IS: \n[");
                Node current = this.head;
                while (current != null) {
                    System.out.print(current.data);
                    if (current.next != null)
                        System.out.print(", ");
                    current = current.next;
                }
                System.out.println("]\n");
            }
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }


    // Tests.
    public static void main(String[] args) {
    }

}
