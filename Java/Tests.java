import Lists.*;
import Queue.*;
import Stack.*;

class Tests {

    public static int stack() {
        // Tests for Stack.
        //try {
            Stack stack = new SimpleStack();
            stack.push(100);
            stack.push("A Fucking String");
            stack.push(300);
            stack.push(400);
            System.out.println("Top element is " + stack.peek() + ".");
            System.out.println(stack.pop() + " is removed.");
            System.out.println(stack.peek());
            System.out.println("Length is " + stack.getLength() + ".");
            stack.clear();
            assert stack.isEmpty();
            System.out.println(stack);
        //} catch (Exception e) {
        //    return 1;
        //}
        return 0;
    }

    public static int queue() {
        // Tests for Queue.
        //try {
            Queue queue = new SimpleQueue();
            queue.push(100);
            queue.push("Strings!");
            queue.push(300);
            queue.push(400);
            System.out.println("Next element is " + queue.peek() + ".");
            System.out.println(queue);
            System.out.println(queue.pop() + " is removed.");
            System.out.println(queue);
            queue.clear();
            assert queue.isEmpty();
            System.out.println(queue);
            return 0;
        //}catch (Exception e) {
        //    return 1;
        //}
    }

    public static int singlyLinkedList() {
        // Tests for singly linked list.
        // try {
            LinkedList ll = new SinglyLinkedList();
            ll.addAtStart(200);
            ll.addAtStart(100);
            ll.addAtStart("Now I can add strings too!");
            ll.addAtEnd(300);
            ll.addAtEnd(400);
            System.out.println(ll.getAt(0));
            System.out.println(ll.getAt(1));
            System.out.println(ll);
            ll.removeAt(3);
            System.out.println(ll);
            ll.clear();
            System.out.println(ll);
            return 0;
        //} catch (Exception e) {
        //      return 1;
        //}
    }

    public static int doublyLinkedList() {
        // Tests for doubly linked list.
        // try {
            LinkedList dll = new DoublyLinkedList();
            dll.addAtStart(200);
            dll.addAtStart(100);
            dll.addAtStart("Now I can add strings too!");
            dll.addAtEnd(300);
            dll.addAtEnd(400);
            System.out.println(dll.getAt(0));
            System.out.println(dll.getAt(1));
            System.out.println(dll);
            dll.removeAt(3);
            System.out.println(dll);
            dll.clear();
            System.out.println(dll);
            return 0;
        //} catch (Exception e) {
        //      return 1;    
        //}
    }
        
    public static void main(String[] args) {
        // Prompt user for data strcuture they want to perform actions on;
        // TODO Choose file on which tests will take place on the go...

        System.out.println("-------------");
        System.out.println("Performing tests on Simple Stack: \n");
        Tests.stack();

        System.out.println("\n-------------");
        System.out.println("Performing tests on Queue: \n");
        Tests.queue();

        System.out.println("\n-------------");
        System.out.println("Performing tests on Singly Linked List: \n");
        Tests.singlyLinkedList();

        System.out.println("\n-------------");
        System.out.println("Performing tests on Doubly Linked List: \n");
        Tests.doublyLinkedList();

        System.out.println("\n-------------");
        System.out.println("Tests done. Good Work!\n");
    }

}

