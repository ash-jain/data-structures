package Stack;

public class SimpleStack implements Stack {

    private Object[] data;
    private int len;
    private static int size;

    static {
        size = 25;
    }

    // Initialize.
    public SimpleStack() {
        this.data = new Object[size];
        this.len = 0;
    }

    // Add element on the stack.
    public int push(Object obj) {
        try {
            if (this.data == null)
                data = new Object[size];
            if (this.len == size)
                this.extend();
            this.data[this.len++] = obj;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Increases size of the stack dynamically.
    private int extend() {
        try {
            size *= 2;
            Object[] olddata = this.data;
            this.data = new Object[size];
            for (int i = 0; i < this.len; i++)
                this.data[i] = olddata[i];
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Print topmost element on the stack.
    public Object peek() {
        try {
            if (this.isEmpty())
                return null;
            return this.data[this.len-1];
        } catch (Exception e) {
            return -1;
        }
    }

    // Remove and return top element on the stack.
    public Object pop() {
        try {
            Object obj = this.data[this.len-1];
            remove(this.len-1);
            return obj;
        } catch (Exception e) {
            return -1;
        }
    }

    // Removes element at specified index.
    public int remove(int index) {
        try {
            if (index < 0 || index >= this.len)
                return 1;
            this.data[index] = null;
            this.len--;
            for (int i = index; i < this.len; i++)
                this.data[i] = this.data[i+1];
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // Deletes the queue.
    public int clear() {
        try {
            this.data = null;
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if the queue is empty, otherwise false.
    public boolean isEmpty() {
        return this.len == 0;
    }

    // Returns the length of the stack.
    public int getLength() {
        return this.len;
    }

    // Stringifies the stack data.
    public String toString() {
        try {
            if (this.len == 0)
                return "[]";
            String result = "[";
            for (int i = 0; i < this.len; i++) {
                if (this.data[i] instanceof String)
                    result += "\"" + this.data[i] + "\", ";
                else
                    result += this.data[i] + ", ";
            }
            return result.substring(0, result.length()-2) + "]";
        } catch (Exception e) {
            return null;
        }
    }

    // Print whole stack.
    @Deprecated
    public int printStack() {
        // If stack is empty.
        if (this.len == 0) { 
            System.out.print("\nSTACK IS EMPTY."); 
            return -1;
        }

        System.out.println("\nCURRENT STACK IS: ");
        for (int i = 0; i < this.len; i++)
            System.out.print(" " + this.data[i] + " |");
        System.out.println("\n");
        return 0;
    }

    public static void main(String[] args) {

        Stack stack = new SimpleStack();
        stack.push(100);
        stack.push("A Fucking String");
        stack.push(300);
        stack.push(400);
        System.out.println("Top element is " + stack.peek() + ".");
        System.out.println(stack.pop() + " is removed.");
        System.out.println(stack);
        System.out.println("Length is " + stack.getLength() + ".");
        stack.clear();
        System.out.println(stack);

    }

}    