package Queue;

class SimpleQueue implements Queue {

    private Object[] data;
    private int len;
    private static int size;

    static {
        size = 25;
    }

    // Initialize.
    public SimpleQueue() {
        data = new Object[size];
        this.len = 0;
    }

    // Add element to the end of the queue.
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

    // Increases size of the queue dynamically.
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

    // Show next element in the queue.
    public Object peek() {
        try {
            if (this.isEmpty())
                return null;
            return this.data[0];
        } catch (Exception e) {
            return null;
        }
    }

    // Remove & return next element in the queue.
    public Object pop() {
        try {
            Object obj = this.data[0];
            remove(0);
            return obj;
        } catch (Exception e) {
            return null;
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
        return (this.len == 0);
    }

    // Returns the length of the queue.
    public int getLength() {
        return this.len;
    }

    // Stringifies the queue.
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

    // Print whole queue.
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