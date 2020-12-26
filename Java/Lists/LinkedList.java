/*
* Linked list interface.
* This interface specifies mandotary methods which each list must implement.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com.
*/

package Lists;

public abstract interface LinkedList {

    // Add node at the start and end of the list
    // return 0, 1 in case of a exception.
    public int addAtStart(Object obj); // O(1)
    public int addAtEnd(Object obj); // O(1) / O(n) if tail isn't specified.

    // Add node at a specified index. Supports negative indexing and parameterising
    // index value more than length of the list appends the node at the end.
    // Returns 0 if everything goes smoothly as planned, 1 if index specified is incorrect and 
    // -1 if there's a exception.
    public int insertAt(Object obj, int index); // O(n)

    // Returns node data at specified index. Supports negative indexing and parameterising
    // index value more than the length of the list returns data from the node at the end.
    // Returns the data if there's no issue, null in case of incorrect index or exception.
    public Object getAt(int index); // O(n)
    
    // Removes node at specified index. Does NOT support negative or overflowing values.
    // Returns 0 if it goes smoothly, 1 in case of incorrect indexes and -1 in case of exception.
    public int removeAt(int index); // O(n)
    // Clears the list and returns 0. Returns 1 in case of exception.
    public int clear(); //TODO
    // Returns true if list is empty otherwise false.
    public boolean isEmpty(); // O(1)
    
    // Returns length of the string. (Total number of nodes)
    public int getLength(); // O(1)
    // Stringifies the list output.
    @Override
    public String toString(); // O(n)

    // For debugging only.
    @Deprecated
    public int printList(); // O(n)
    
}
