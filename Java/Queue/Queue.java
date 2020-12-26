/*
* Queue interface.
* Queue works on FIFO (First-in-first-out) basis. 
* Each element/node is added at the back and returned from the front.
* This interface states mandotary methods which each queue must implement. 
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com
*/

package Queue;

public abstract interface Queue {
    
    // Add node to the (end of) queue
    // return 0, 1 in case of exception.
    public int push(Object obj); // O(1)

    // Returns next (first) node in the queue,
    // Empty queue returns null and exception returns -1.
    public Object peek(); // O(1)

    // Returns and removes next (first) node in the queue.
    // Empty queue returns null and exception returns -1.
    public Object pop(); // O(1)
    // Removes node at specified index. Does NOT support negative or overflowing values.
    // Returns 0, 1 in case of invalid indexes and -1 in case of exception.
    public int remove(int index); // O(n)
    // Clears the queue and returns 0, 1 in case of a exception.
    public int clear(); // O(1) for simple queue using arrays, O(n) for linked queue.
    // Returns true if queue is empty or false otherwise.
    public boolean isEmpty(); // O(1)

    // Returns length of the queue. (Total number of nodes)
    public int getLength(); // O(1)
    // Stringifies the raw queue data.
    @Override
    public String toString(); // O(n)
    
}
