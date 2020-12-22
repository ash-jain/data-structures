package Lists;

public class DoublyLinkedList implements LinkedList {


    // Node.
    private class Node {

        private Object data;
        private Node prev, next;

        Node(Object obj, Node prev, Node next) {
            this.data = obj;
            this.prev = prev;
            this.next = next;
        }

    }


    private Node head;
    private Node tail;
    public int len;

    public DoublyLinkedList() {
        this.head = this.tail = new Node(null, null, null); // Not mandotary.
        this.len = 0;
    }

    // Add first element.
    private int addFirst(Object obj) {
        try {
            this.head = this.tail = new Node(obj, null, null);
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
            this.head = new Node(obj, null, this.head);
            this.head.next.prev = this.head;
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add at end of the list.
    public int addAtEnd(Object obj) {
        try {
            if (this.len == 0)
                return addFirst(obj);
            else {
                this.tail = this.tail.next = new Node(obj, this.tail, null);

                /* If tail is not set. (Inefficient)
                Node current = this.head;

                while(current.next != null)
                    current = current.next;

                current.next = new Node(obj, null, null);
                current.next.prev = current;
                this.tail = current.next;
                */
            }
            this.len++;
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // Insert at particular index. Supports negative indexing. -1 means end of this list.
    public int insertAt(Object obj, int index) {
        try {
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);
            else if (index < 0)
                return 1;

            if (index == 0)
                return addAtStart(obj);
            else if (index >= this.len-1)
                return addAtEnd(obj);
            else if (index <= this.len/2 + 1) {
                Node current = this.head;

                for (int i = 0; i < index; i++)
                    current = current.next;

                current.next = new Node(obj, current, current.next);
                current.next.next.prev = current.next;
            } else {
                Node current = this.tail;

                for (int i = this.len; i > index; i--)
                    current = current.prev;

                current.next = new Node(obj, current, current.next);
                current.next.next.prev = current.next;
            }
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }    
    }

    // Returns element by index number. Supports negative indices. -1 returns last element in the list.
    public Object getAt(int index) {
        try {
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);

            if (index <= this.len/2 + 1) {
                Node current = this.head;
                for (int i = 0; i < index; i++)
                    current = current.next;
                return current.data;
            } else {
                Node current = this.tail;
                for (int i = this.len-1; i > index; i--)
                    current = current.next;
                return current.data;
            }
        } catch (Exception e) {
            return null;
        }
    }

    // Remove element at specified index.
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

    // Delete list.
    public int clear() {
        try {
            this.head = this.tail = null;
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if list is empty otherwise false.
    public boolean isEmpty() {
        return this.head == null && this.head.data == null && this.head.next == null && this.tail == null && this.tail.data == null && this.tail.prev == null && this.tail.next == null;
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
            while (current != null) {
                if (current.data instanceof String)
                    result += "\"" + current.data + "\", ";
                else 
                    result += current.data + ", ";
                current = current.next;
            }
            return result.substring(0, result.length()-2) + "]";
        } catch (Exception e) {
            return null;
        }
    }


    // Deprecated. (Was being used for debugging)
   @Deprecated 
    public int printList() {
        try {
            if (this.len == 0)
                System.out.println("\nThe list is empty.");
            else {
                System.out.println("\nThe elements in the list are: ");
                Node current = this.head;
                while (current != null) {
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

    // Deprecated. (Was being used for debugging)
    @Deprecated
    public void printListRev() {
        Node current = this.tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    public static void main(String[] args)
    {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addAtStart("Called First");
        dll.addAtEnd("Called Second");
        dll.addAtEnd("Called Third");
        dll.addAtEnd("Called Fourth");

        System.out.println(dll);
    }

    
}
