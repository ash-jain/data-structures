package Stack;

public class LinkedStack implements Stack {


    private class Node {

        private Object data;
        private Node prev;
        private Node next;

        Node(Object obj, Node prev, Node next) {
            this.data = obj;
            this.prev = prev;
            this.next = next;
        }

    }
    
    private Node head;
    private Node tail;
    private int len;

    public LinkedStack() {
        this.head = this.tail = new Node(null, null, null);
    }

    private int addFirst(Object obj) {
        try {
            this.head = this.tail = new Node(obj, null, null);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public int push(Object obj) {
        try {
            if (this.len == 0)
                return this.addFirst(obj);
            this.tail = this.tail.next = new Node(obj, this.tail, null);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public Object peek() {
        try {
            return this.tail.data;
        } catch (Exception e) {
            return null;
        }
    }

    public Object pop() {
        try {
            Node n = this.tail;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.len--;
            return n;
        } catch (Exception e) {
            return null;
        }
    }

    public int remove(int index) {
        try {
            if (index < 0 || index >= this.len)
                return 1;
            Node current = this.head;
            for (int i = 0; i < index; i++)
                current = current.next;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            this.len--;
            if (index == 0)
                this.head = current.next;
            else if (index == this.len)
                this.tail = current.prev;
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public int clear() {
        try {
            this.head = this.tail = new Node(null, null, null);
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
        
    public boolean isEmpty() {
        return this.len == 0 && this.head.data == null && this.head.next == null && this.tail.data == null & this.tail.prev == null;
    }

    public int getLength() {
        return this.len;
    }

    public String toString() {
        if (this.len == 0)
            return "[]";
        String result = "[";
        Node current = this.head;
        while (current.data != null) {
            if (current.data instanceof String)
                result += "\"" + current.data + "\", ";
            else
                result += current.data + ", ";
        }
        return result.substring(0, result.length()-2) + "]";
    }

    @Deprecated
    public int printStack() {
        try {
            if (this.len == 0)
                System.out.println("QUEUE IS EMPTY.");
            else {
                Node current = this.head;
                System.out.println("\nCURRENT QUEUE IS: ");
                while (current.data != null)
                    System.out.println(" " + current.data + " |");
            }
            System.out.println("\n");
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
    }
}
