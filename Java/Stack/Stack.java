package Stack;

public interface Stack {

    public int push(Object val);

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
    public int printStack();
    */
    
}
