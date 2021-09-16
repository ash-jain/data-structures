/*
* Implementation of a simple queue using an array to store the data.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Queues;

public class SimpleQueue implements Queue {

    // This array stores the data. Data can be anything strings, integers, floats and so on
    // Custom objects using private classes can be also created to suit organizational needs.
    private Object[] data;
    // Length of the queue. (Total number of nodes in the queue)
    private int len;
    // Size of the array.
    private static int size;

    static {
        // Can be set differently according to the needs.
        size = 25;
    }

    // Constructor.
    public SimpleQueue() {
        // Initialize the array.
        data = new Object[size];
        this.len = 0;
    }

    // Add object to the (end of) queue. O(1) / O(n) if array is overflown.
    public int push(Object obj) { 
        try {
            // Initialize if not done already.
            if (this.data == null) {
                data = new Object[size];
                this.len = 0;
            }
            // If data being pushed exceeds the current size of the array.
            else if (this.len == size)
                this.extend();
            // Set the data at last place in the array and increment the length.
            this.data[this.len++] = obj;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Increase size of the queue dynamically. O(n)
    private int extend() {
        try {
            // Double the size, make a copy of the data.
            size *= 2;
            Object[] olddata = this.data;
            // Create new array with twice the size.
            this.data = new Object[size];
            // Set all the values in copy to current array indices respectively.
            for (int i = 0; i < this.len; i++)
                this.data[i] = olddata[i];
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return next node in the queue. O(1)
    public Object peek() {
        try {
            if (this.isEmpty())
                return null;
            return this.data[0];
        } catch (Exception e) {
            return -1;
        }
    }

    // Remove and return next node in the queue. O(n)
    public Object pop() {
        try {
            if (this.isEmpty())
                return null;
            // Copy the data, remove it from the array and then return the value(s).
            Object obj = this.data[0];
            remove(0);
            return obj;
        } catch (Exception e) {
            return -1;
        }
    }

    // Remove node at specified index. Does NOT support negative or overflowing indexes. O(n)
    public int remove(int index) {
        try {
            // Check for invalid index.
            if (index < 0 || index >= this.len)
                return 1;
            // Shift over the next nodes in the array.
            for (int i = index; i < this.len; i++)
                this.data[i] = this.data[i+1];
            this.len--;
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // Delete the queue. O(1)
    public int clear() {
        try {
            // Set data to null and restore all variables to initial states.
            this.data = null;
            this.len = 0;
            SimpleQueue.size = 25;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if the queue is empty, false otherwise. O(1)
    public boolean isEmpty() {
        return this.data == null && this.len == 0;
    }

    // Return the length of the queue. O(1)
    public int getLength() {
        return this.len;
    }

    // Stringify the queue data. O(n)
    @Override
    public String toString() {
        try {
            if (this.isEmpty())
                return "[]";

            String result = "[";
            for (int i = 0; i < this.len; i++) {
                // Add quotes if the object is a string.
                if (this.data[i] instanceof String)
                    result += "\"" + this.data[i] + "\", ";
                else
                    result += this.data[i] + ", ";
            }
            // Remove 2 unnecessary characters from the last node.
            return result.substring(0, result.length()-2) + "]";
        } catch (Exception e) {
            return null;
        }
    }

    // Print the queue data.
    @Deprecated
    public int printQueue() {
        if (this.isEmpty()) {
            System.out.println("QUEUE IS EMPTY.");
            return -1;
        }

        System.out.println("\nCURRENT QUEUE IS: ");
        for (int i = 0; i < this.len; i++)
            System.out.print(" " + this.data[i] + " |" );
        System.out.println("\n");
        return 0;
    }


    // Tests
    public static void main(String[] args) {
    }

}