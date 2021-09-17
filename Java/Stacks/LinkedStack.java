/*
* Implementation of simple linked stack using linear linked list to store the data.
* Each node has two pointers - one to the previous node and one to next node.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com
*/

package Stacks;

public class LinkedStack implements Stack {

    // Node prototype.
    private class Node {

        // Mode data. Data can be any object
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

    // First node in the stack.
    private Node head;
    // Last node in the stack.
    private Node tail;
    // Length of the stack. (Total number of nodes on the stack)
    private int len;

    // Initialize the list.
    public LinkedStack() {
        // Not necessary to set just better practice.
        this.head = this.tail = new Node(null, null, null);
        this.len = 0;
    }

    // Add first node when the stack in empty. O(1)
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

    // Add object to the top of the stack. O(1)
    public int push(Object obj) {
        try {
            if (this.isEmpty())
                return this.addFirst(obj);
            // Create new node whose previous pointer points at current tail.
            // Set this node to pointer of tail and then set tail to this node.
            this.tail = this.tail.next = new Node(obj, this.tail, null);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return topmost node on the stack. O(1)
    public Object peek() {
        try {
            return this.tail.data;
        } catch (Exception e) {
            return null;
        }
    }

    // Remove and return topmost node on the stack. O(1)
    public Object pop() {
        try {
            // Copy over the data from node to be removed.
            Object data = this.tail.data;
            // If there's only one element on the stack.
            if (this.len == 1) {
                this.tail.data = null;
                this.head = this.tail = new Node(null, null, null);
                this.len--;
            }
            else if (!this.isEmpty()) {
                // Delete the data at tail and set tail to previous node with its
                // next pointer set to null as it is now the topmost node on the stack.
                this.tail.data = null;
                this.tail = this.tail.prev;
                this.tail.next = null;
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
            // If there's only one element on the stack.
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

    // Return true if the stack is empty, false otherwise. O(1)
    public boolean isEmpty() {
        return this.len == 0 && this.head.data == null & this.tail.data == null;
    }

    // Return length of the stack. O(1)
    public int getLength() {
        return this.len;
    }

    // Stringify the stack data. O(n)
    @Override
    public String toString() {
        try {
            if (this.isEmpty())
                return "\n-------\n|     |\n-------\n";

            Node current = this.tail;
            // TODO Add dashes dynamically based on the longest element on the stack.
            String result = "\n-------\n";
            while (current != null) {
                // Add quotes if the object is a string.
                if (current.data instanceof String)
                    result += "| \"" + current.data + "\" |\n";
                else
                    result += "| " + current.data + " |\n";
                current = current.prev;
            }
            // Add finishing dashes.
            return result + "-------\n";
        } catch (Exception e) {
            return null;
        }
    }

    // Print the stack data.
    @Deprecated
    public int printStack() {
        try {
            if (this.isEmpty())
                System.out.println("STACK IS EMPTY.");
            else {
                System.out.println("\nCURRENT STACK IS: ");
                Node current = this.head;

                System.out.println("-------");
                while (current != null) {
                    System.out.println("| " + current.data + " |");
                    current = current.next;
                }
                System.out.println("-------\n");
            }
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }


    // Tests
    public static void main(String[] args) {
    }

}
