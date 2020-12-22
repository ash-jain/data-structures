package Lists;

public class CircularLinkedList implements LinkedList {


    // Node.
    private class Node {

        private Object data;
        private Node next;

        Node(Object obj, Node next) {
            this.data = obj;
            this.next = next;
        }

    }


    private Node head;
    private int len;

    public CircularLinkedList() {
        this.head = new Node(null, null); // Unnecessary.
        this.len = 0;
    }

    // Add first element.
    public int addFirst(Object obj) {
        try {
            this.head = new Node(obj, null);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add element at the start of the list.
    public int addAtStart(Object obj) {
        try {
            if (this.len == 0)
                return addFirst(obj);
            this.head = new Node(obj, this.head);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add at the end of the list.
    public int addAtEnd(Object obj) {
        try {
            if (this.len == 0)
                return addFirst(obj);
            else {
                Node current = this.head;
                for (int i = 0; i < this.len; i++)
                    current = current.next;
                current.next = new Node(obj, this.head);
            }
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
        
    // Insert at particular index. Supports negativeindexing. -1 means end of this list.    
    public int insertAt(Object obj, int index) {
        try {
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);
            else if (index < 0)
                return 1;

            if (index == 0)
                return addAtStart(obj);
            else if (index == this.len-1)
                return addAtEnd(obj);
            else {
                Node current = this.head;
                Node previous = null;
                for (int i = 0; i < index; i++) {
                    previous = current;
                    current = current.next;
                }
                previous.next = new Node(obj, current);
            }
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Returns element by given index. Supports negative indices. -1 returns last element in the list.
    public Object getAt(int index) {
        try {
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);
            else if (index >= this.len )
                return null;

            Node current = this.head;
            for (int i = 0; i < index; i++)
                current = current.next;
            return current.data;
        } catch (Exception e) {
            return null;
        }
    }
    
    // Remove element at speicified index.
    public int removeAt(int index) {
        try {
            if (index >= this.len || index < 0)
                return 1;

            /* Support for negative indices.
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);
            else if (index < 0)
                return 1;
            */

            // TODO check, run tests.
            Node current = this.head;
            Node previous = null;

            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }

            previous.next = current.next;
            this.len--;

            if (index == 0)
                this.head = current.next;

            return 0;
        } catch (Exception e) {
            return -1; 
        }
    }

    // Delete list.
    public int clear() {
        try {
            this.head = null;
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if list is empty otherwise false.
    public boolean isEmpty() {
        return this.head == null && this.head.data == null && this.head.next == null;
    }

    // Return length of the list. 0 if its empty.
    public int getLength() {
        return this.len;
    }

    // Stringifies the object.
    @Override
    public String toString() {
        try {
            if (this.len == 0)
                return "[]";
            Node current = this.head;
            String result = "[";
            for (int i = 0; i < this.len; i++) {
                if (current.data instanceof String)
                    result += "\"" + current.data + "\", ";
                else
                    result += current.data + ", ";
                current = current.next;
            }
            result = result.substring(0, result.length()-2) + "]";
            return result;
        } catch (Exception e) {
            return null;
        }
    }


    // Deprecated. (Was being used for debugging);
    @Deprecated
    public int printList() {
        try {
            if (this.len == 0)
                System.out.println("\nThe list is empty.");
            else {
                System.out.println("\nThe elements in the list are: ");
                Node current = this.head;
                for (int i = 0; i < this.len ; i++) {
                    System.out.println(current.data);
                    current = current.next;
                }
                System.out.println();
            }
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
    
    public static void main(String[] args) {
        LinkedList cll = new CircularLinkedList();
        cll.addAtStart(300);
        cll.addAtStart(200);
        cll.addAtStart(100);
        cll.addAtStart("400");
        System.out.println(cll);
    }


}