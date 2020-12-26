/*
* Implementation of a simple queue using array to store the data.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Queue;

public class SimpleQueue implements Queue {

    // This object array stores the data. Data can be anything Strings, Integers, Floats and so on
    // Custom objects using private classes can be also created to suit organisational needs.
    private Object[] data;
    // Length of the queue. (Total number of nodes in the list)
    private int len;
    // Size of the array.
    private static int size;

    //TODO
    static {
        // Can be set differently according to size the of data.
        size = 25; // DO NOT set any less than 10.
    }

    // Constructor.
    public SimpleQueue() {
        // Initialize the array.
        data = new Object[size];
        this.len = 0;
    }

    // Add element to the end of the queue. O(1) / O(n) if array is overflowed.
    public int push(Object obj) { 
        try {
            // Initialise if not done already.
            if (this.data == null) {
                data = new Object[size];
                this.len = 0;
            }
            // If data being pushed exceedes the current size of the array.
            else if (this.len == size)
                this.extend();
            // Set the data at last place in the array and increment the length.
            this.data[this.len++] = obj;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Increases size of the array dynamically. O(n)
    private int extend() {
        try {
            // Double the size, make a copy of the data.
            size *= 2;
            Object[] olddata = this.data;
            // Create new array with twice the size.
            this.data = new Object[size];
            // Set all the values in copy to current array indexex respectively.
            for (int i = 0; i < this.len; i++)
                this.data[i] = olddata[i];
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Show next element in the queue. O(1)
    public Object peek() {
        try {
            // Return null if empty.
            if (this.isEmpty())
                return null;
            // Otherwise return first element in the queue.
            return this.data[0];
        } catch (Exception e) {
            return -1;
        }
    }

    // Remove & return next element in the queue.
    public Object pop() {
        try {
            // Return null if empty.
            if (this.isEmpty())
                return null;
            // Otherwise copy the data, remove it from array and then return the value(s).
            Object obj = this.data[0];
            remove(0);
            return obj;
        } catch (Exception e) {
            return -1;
        }
    }

    // Removes element at specified index. Does NOT support negative or overflowing indexes. O(n)
    public int remove(int index) {
        try {
            // Invalid index check.
            if (index < 0 || index >= this.len)
                return 1;
            // Set data at index to null and shift over next values.
            this.data[index] = null;
            this.len--;
            for (int i = index; i < this.len; i++)
                this.data[i] = this.data[i+1];
            // TODO Test. Set last data field to null.
            this.data[this.len] = null;
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // Deletes the queue. O(1)
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

    // Return true if the queue is empty, otherwise false. O(1)
    public boolean isEmpty() {
        return this.data == null && this.len == 0;
    }

    // Returns the length of the queue. O(1)
    public int getLength() {
        return this.len;
    }

    // Stringifies the queue data. O(n)
    public String toString() {
        try {
            // If queue is empty
            if (this.isEmpty())
                return "[]";
            String result = "[";
            for (int i = 0; i < this.len; i++) {
                // Adds quotes if object is string.
                if (this.data[i] instanceof String)
                    result += "\"" + this.data[i] + "\", ";
                else
                    result += this.data[i] + ", ";
            }
            // Remove last 2 unnecessary characters.
            return result.substring(0, result.length()-2) + "]";
        } catch (Exception e) {
            return null;
        }
    }

    // Deprecated. Print whole queue.
    @Deprecated
    public int printQueue() {

        // If queue is empty.
        if (this.len == 0) {
            System.out.print("QUEUE IS EMPTY.");
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
        Queue q = new SimpleQueue();
        q.push(100);
        q.push(200);
        q.push(300);
        q.push(400);
        System.out.println(q.peek());
        System.out.println(q);
        q.remove(3);
        System.out.println(q);
    }

}