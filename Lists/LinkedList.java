/*
* Linked list interface.
* This interface specifies mandatory methods which each linked list must implement.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Lists;

public abstract interface LinkedList {

    // Add node at the start and end of the list,
    // return 0; 1 in case of an exception.
    public int addAtStart(Object obj); // O(1)
    public int addAtEnd(Object obj); // O(1) / O(n) if tail isn't set.

    // Add node at a specified index and return 0.
    // Supports negative indexing and index value more than length of the 
    // list appends the node at the end. Return 1 if index specified is incorrect and 
    // -1 in case of an exception.
    public int insertAt(Object obj, int index); // O(n)

    // Return node data at a specified index and return 0.
    // Supports negative indexing and index value more than length of the
    // list returns data from the last node. Return 1 if index is invalid or 
    // an exception occurs.
    public Object getAt(int index); // O(n)

    // Remove node at specified index and return 0, 1 in case of invalid index,
    // -1 in case of an exception. Does NOT support negative or overflowing indexes.
    public int removeAt(int index); // O(n)
    // Clear the list and returns 0. Return 1 if unsuccessful.
    public int clear(); //TODO
    // Return true if list is empty, false otherwise.
    public boolean isEmpty(); // O(1)

    // Return length of the list. (Total number of nodes)
    public int getLength(); // O(1)
    // Stringify the linked list data.
    @Override
    public String toString(); // O(n)

}
