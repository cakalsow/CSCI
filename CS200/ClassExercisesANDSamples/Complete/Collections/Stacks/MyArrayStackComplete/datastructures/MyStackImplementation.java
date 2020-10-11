package datastructures;

import java.util.*;

public class MyStackImplementation < ElementType > implements MyStack<ElementType>{
  // Data Fields
  /** The default initial capacity */
  private static final int INITIAL_CAPACITY = 3;
  
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
    for(ElementType e: this){
      if(e.equals(element)){
        return true;
      }
    }
    return false;
    //CAN WE LOOP DIFFERENTLY?***************************************************************************************
    
//    for(int i=0; i<size;i++){
//      if(theData[i].equals(element)){
//        return true;
//      }
//    }
//    return false;
    
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
    if(isEmpty())
      throw new NoSuchElementException("Can't PEEK an empty stack");
    return theData[size-1];
    //REDO WITH TOP AT LOC 0 *****************************************************************************************
//    if(isEmpty())
//      throw new NoSuchElementException("Can't PEEK an empty stack");
//    return theData[0];
  }
  
  /**
   * Removes and returns the top element of this stack.
   * 
   * @return the top element of this stack
   * @throws NoSuchElementException if this stack is empty
   */
  public ElementType pop(){
    if(isEmpty())
      throw new NoSuchElementException("Can't POP an empty stack");
    ElementType top = theData[size-1];
    size--;
    return top;
    //REDO WITH TOP AT LOC 0 *****************************************************************************************
//    if(isEmpty())
//      throw new NoSuchElementException("Can't POP an empty stack");
//    ElementType top = theData[0];
//    for(int i=0; i<size-1;i++){
//      theData[i] = theData[i+1];
//    }
//    size--;
//    return top;    
  }
  
  /**
   * Adds a new element to the top of this stack.
   * 
   * @param element the element to be added
   */
  public void push(ElementType element){    
    if (size == capacity) {
      reallocate();
    }
    theData[size] = element;
    size++;
    //REDO WITH TOP AT LOC 0 *****************************************************************************************    
//    if (size == capacity) {
//      reallocate();
//    }
//    for(int i=size; i>0;i--){
//      theData[i] = theData[i-1];
//    }
//    theData[0] = element;
//    size++;
  }
  
  
  private void reallocate() {
    capacity = 2 * capacity;
    ElementType[] newData = (ElementType[])new Object[capacity];
    System.arraycopy(theData, 0, newData, 0, size);
    theData = newData;
  } 
  
  
  private class InternalIterator implements Iterator<ElementType>{
    private int position;
    
    /**
     * METHODS NEEDED TO IMPLEMENT the Iterator INTERFACE
     */
    
    public InternalIterator(){
      this.position=0;
    }
    
    public boolean hasNext(){
      return this.position<size;
    }
    
    public void remove(){
      throw new UnsupportedOperationException("Remove");
    }
    
    public ElementType next(){
      if(hasNext()){
        return theData[this.position++];
      }
      else{
        throw new NoSuchElementException();
      }
    }
  }
}