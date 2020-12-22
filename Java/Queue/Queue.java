package Queue;

public interface Queue {
    public int push(Object obj);

    public Object peek();

    public Object pop();
    public int remove(int index);
    public int clear();
    public boolean isEmpty();

    public int getLength();
    public String toString();

    /*
    // For debugging only.

    @Deprecated
    public int printQueue();
    */
    
}
