/*
* Queue interface.
* Queue works on FIFO (First-in-first-out) basis.
* Each node is added at the back and returned from the front.
* This interface states mandatory methods which each queue must implement.
* Author - Aakash "Ash" Jain.
* Contact - aakashjainofficial@gmail.com
*/

package Queues;

public abstract interface Queue {

    // Add object to the (end of) queue,
    // return 0; 1 in case of an exception.
    public int push(Object obj); // O(1)

    // Return next (first) node in the queue,
    // null if queue is empty, -1 in case of an exception.
    public Object peek(); // O(1)

    // Remove and return next (first) node in the queue,
    // return null if queue is empty, -1 in case of an exception.
    public Object pop(); // O(1)
    // Remove node at specified index and return 0, 1 in case of invalid index,
    // -1 in case of an exception. Does NOT support negative or overflowing values.
    public int remove(int index); // O(n)
    // Clear the queue and return 0, 1 if some error occurs.
    public int clear(); // O(1) for simple queue using arrays, O(n) for linked queue.
    // Return true if the queue is empty, false otherwise.
    public boolean isEmpty(); // O(1)

    // Return length of the queue. (Total number of nodes)
    public int getLength(); // O(1)
    // Stringify the queue data.
    @Override
    public String toString(); // O(n)

}
