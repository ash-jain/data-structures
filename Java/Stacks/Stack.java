/*
* Stack interface.
* Stack works on LIFO (Last-in-first-out) basis.
* Each node is added to and removed from the top of the stack.
* This interface states mandatory methods which each stack must implement.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com
*/

package Stacks;

public abstract interface Stack {

    // Add object to the top of the stack,
    // return 0; 1 in case of a exception.
    public int push(Object val); // O(1)

    // Return topmost node on the stack,
    // null in stack in empty, -1 in case of exception.
    public Object peek(); // O(1)

    // Remove and return topmost node on the stack,
    // return null if stack is empty, -1 in case of exception.
    public Object pop(); // O(1)
    // Remove node at specified index and return 0, 1 in case of invalid index,
    // -1 if case of exception. Does NOT support negative or overflowing values.
    public int remove(int index); // O(n)
    // Clear the stack and return 0, 1 if some error occurs.
    public int clear(); // O(1) for simple stack using arrays, O(n) for linked stack.
    // Return true if the stack is empty, false otherwise.
    public boolean isEmpty(); // O(1)

    // Return the length of the stack. (Total number of nodes)
    public int getLength();
    // Stringify the raw stack data.
    @Override
    public String toString(); // O(n)

}
