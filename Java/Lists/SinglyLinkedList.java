package Lists;

class SinglyLinkedList implements LinkedList {


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
    private Node tail;
    private int len;

    public SinglyLinkedList() {
        this.head = this.tail = new Node(null, null); // Not mandotary.
        this.len = 0;
    }

    // Add first element.
    private int addFirst(Object obj) {
        try {
            this.head = this.tail = new Node(obj, null);
            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Add node at the start of the list.
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

    // Add a node at the end.
    public int addAtEnd(Object obj) {
        try {
            if (this.len == 0)
                return addFirst(obj);

            this.tail = this.tail.next = new Node(obj, null);

            /* If tail is not set. (Inefficient)
             Node current = this.head;

            for (int i = 0; i < this.len-1; i++)
                current = current.next;
                current.next = new Node(obj, null);
            */

            this.len++;
            return 0;
        } catch (Exception e) {
            return 1;
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
            return -1;
        }
    }

    // Returns object at specifed index. Support for negative indices. -1 returns last element in the list.
    public Object getAt(int index) {
        try {
            if (index < 0 && index * (-1) < this.len)
                index = this.len - index * (-1);

            Node current = this.head;
            for (int i = 0; i < index; i++)
                current = current.next;
            return current.data;
        } catch (Exception e) {
            return null;
        }
    }

    // Remove an element at an index.
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

            Node current = this.head;
            Node previous = null;

            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }

            previous.next = current.next;
            this.len--;

            if (index == this.len)
                this.tail = previous;
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    // Delete list.
    public int clear() {
        try {
            this.head = new Node(null, null);
            this.len = 0;
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    // Return true if list is empty otherwise false.
    public boolean isEmpty() {
        return (this.head == null);
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
                while(current != null) {
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

    /*
    @Deprecated
    public Object pop(int index) {
        Object obj = getAt(index);
        removeAt(index);
        return obj;
    }
    */

    public static void main(String[] args) {
        LinkedList ll = new SinglyLinkedList();
        ll.addAtStart(400);
        ll.addAtStart(300);
        ll.addAtStart(200);
        ll.addAtStart(100);
        System.out.println(ll.getAt(0));
        System.out.println(ll.getAt(1));
        System.out.println(ll.getAt(2));
        System.out.println(ll.getAt(3));
        System.out.println(ll);
        ll.removeAt(3);
        System.out.println(ll);
        ll.clear();
        System.out.println(ll);
    }


}