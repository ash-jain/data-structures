/*
* Implementation of simple stack using an array to store the data.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Stacks;

public class SimpleStack implements Stack {

    // This array stores the data. Data can be anything strings, integers, floats and so on
    // Custom objects using private classes can be also be created to suit organizational needs.
    private Object[] data;
    // Length of the stack. (Total number of nodes on the stack)
    private int len;
    // Size of the array.
    private static int size;

    static {
        // Can be set differently according to the needs.
        size = 25;
    }

    // Constructor.
    public SimpleStack() {
        // Initialize the array.
        this.data = new Object[size];
        this.len = 0;
    }

    // Add object to the top of the stack. O(1) / O(n) if array is overflown.
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

    // Increase the size of the stack dynamically. O(n)
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

    // Return topmost node on the stack. O(1)
    public Object peek() {
        try {
            if (this.isEmpty())
                return null;
            return this.data[this.len-1];
        } catch (Exception e) {
            return -1;
        }
    }

    // Remove and return topmost node on the stack. O(n)
    public Object pop() {
        try {
            if (this.isEmpty())
                return null;
            // Copy the data, remove it from the array and then return the value(s).
            Object obj = this.data[this.len-1];
            remove(this.len-1);
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

    // Delete the stack. O(1)
    public int clear() {
        try {
            // Set data to null and restore all variables to initial states.
            this.data = null;
            this.len = 0;
            SimpleStack.size = 25;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if the stack is empty, false otherwise.
    public boolean isEmpty() {
        return this.data == null && this.len == 0;
    }

    // Return the length of the stack. O(1)
    public int getLength() {
        return this.len;
    }

    // Stringify the stack data. O(n)
    @Override
    public String toString() {
        try {
            if (this.isEmpty())
                return "\n-------\n|     |\n-------\n";


            // TODO Add dashes dynamically based on the longest element on the stack.
            String result = "\n-------\n";
            for (int i = 0; i < this.len; i++) {
                // Add quotes if the object is a string.
                if (this.data[i] instanceof String)
                    result += "| \"" + this.data[i] + "\" |\n";
                else
                    result += "| " + this.data[i] + " |\n";
            }
            // Remove 2 unnecessary characters from the last node.
            return result + "-------\n";
        } catch (Exception e) {
            return null;
        }
    }

    // Print whole stack.
    @Deprecated
    public int printStack() {
        if (this.isEmpty()) { 
            System.out.print("\nSTACK IS EMPTY.\n"); 
            return -1;
        }
        System.out.println("\nCURRENT STACK IS: \n-------");
        for (int i = 0; i < this.len; i++)
            System.out.println("| " + this.data[i] + " |");
        System.out.println("-------\n");
        return 0;
    }


    // Tests.
    public static void main(String[] args) {
    }

}