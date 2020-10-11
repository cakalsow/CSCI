package datastructures;

import java.util.*;

public class MyStackImplementation < ElementType > implements MyStack<ElementType>{
  // Data Fields
  /** The default initial capacity */
  private static final int INITIAL_CAPACITY = 4;
  
  /** The underlying data array */
  private ElementType[] theData;
  
  /** The current size */
  private int size = 0;
  
  /** The current capacity */
  private int capacity = 0;
  
  /** Construct an empty MyStackImplementation with the default
    initial capacity
    */
  public MyStackImplementation() {
    capacity = INITIAL_CAPACITY;
    theData = (ElementType[])new Object[capacity];
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#isEmpty()
   */
  public boolean isEmpty(){
    return size==0;
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#contains(java.lang.Object)
   */
  public boolean contains(ElementType element){
    if (MyStack.empty()==true)
    {
     return "This stack is empty."; 
    }
    return false;
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#iterator()
   */
  public Iterator<ElementType> iterator(){
    return new InternalIterator();
  }
  /**
   * Returns the top element of this stack without removing it.
   * 
   * @return the top element of this stack
   * @throws NoSuchElementException if this stack is empty
   */
  public ElementType peek(){
    if (isEmpty())
      throw new NoSuchElementException("Can't PEEK an empty stack.");
    return theData[size - 1];
  }
  
  /**
   * Removes and returns the top element of this stack.
   * 
   * @return the top element of this stack
   * @throws NoSuchElementException if this stack is empty
   */
  public ElementType pop(){
    if (isEmpty())
      throw new NoSuchElementException("Can't POP an empty stack.");
    ElementType top = theData[size - 1];
    size--;
    return top;
  }
  
  /**
   * Adds a new element to the top of this stack.
   * 
   * @param element the element to be added
   */
  public void push(ElementType element){    
//COMPLETE ME .......................................................................................................
  }
  
  private void reallocate() {
    capacity = 2 * capacity;
    ElementType[] newData = (ElementType[])new Object[capacity];
    System.arraycopy(theData, 0, newData, 0, size);
    theData = newData;
  } 
  
  
  private  class InternalIterator implements Iterator<ElementType>{
    private int position;
    
    /**
     * METHODS NEEDED TO IMPLEMENT the Iterator INTERFACE
     */
    
    public InternalIterator(){
      this.position=0;
    }
    
    public boolean hasNext(){
//COMPLETE ME .......................................................................................................
      return false;
    }
    
    public void remove(){
      throw new UnsupportedOperationException("Remove");
    }
    
    public ElementType next(){
//COMPLETE ME .......................................................................................................
      return null;
    }
  }
}
