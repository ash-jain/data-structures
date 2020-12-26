/*
* Stack interface.
* Stack works on LIFO (Last-in-first-out) basis.
* Each element/node is added and removed from the top of the stack
* This interface states mandotary methods which each queue must implement
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com
*/

package Stack;

public abstract interface Stack {

    // Add element/node to the top of the stack
    // Return 0, 1 in case of a exception.
    public int push(Object val); // O(1)

    // Return topmost node in the stack,
    // Empty stack returns null and exception -1.
    public Object peek(); // O(1)

    // Returns and remoes top element/node in the stack.
    // Empty stack returns null and exception returns -1.
    public Object pop(); // O(1)
    // Removes node at specified index. Does NOT support negative or overflowing values.
    // Returns 0, 1 in case of invalid indexes and -1 in case of exception.
    public int remove(int index); // O(n)
    // Clears the stack, deletes all values and returns 0. 1 in case of a exception.
    public int clear(); // O(1) for simple stack using arrays, O(n) for linked stack
    // Returns true is stack is empty or false otherwise.
    public boolean isEmpty(); // O(1)
    
    // Returns the length of the stack. (Total number of nodes)
    public int getLength();
    // Stringifies the raw stack data.
    @Override
    public String toString(); // O(n)
    
}
