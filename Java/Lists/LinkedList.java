package Lists;

public interface LinkedList {

    public int addAtStart(Object obj);
    public int addAtEnd(Object obj);
    public int insertAt(Object obj, int index);

    public Object getAt(int index);
    
    public int removeAt(int index);
    public int clear();
    public boolean isEmpty();
    
    public int getLength();
    public String toString();

    // For debugging only.
    @Deprecated
    public int printList();
    
}
