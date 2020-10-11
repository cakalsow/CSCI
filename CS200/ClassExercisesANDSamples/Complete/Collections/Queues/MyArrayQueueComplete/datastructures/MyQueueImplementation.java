package datastructures;

import java.util.*;

/** 
 * Class to implement interface MyQueue as an array.
 * 
 * @author Rahal
 * @version 09/16/2016
 */
public class MyQueueImplementation < ElementType > implements MyQueue<ElementType>{
  // Data Fields
  /** The default initial capacity */
  private static final int INITIAL_CAPACITY = 10;
  
  /** The underlying data array */
  private ElementType[] theData;
  
  /** The current size */
  private int size = 0;
  
  /** The current capacity */
  private int capacity = 0;
  
  /** 
   * Construct an empty MyQueueImplementation with the default
   * initial capacity
   */
  public MyQueueImplementation() {
    capacity = INITIAL_CAPACITY;
    theData = (ElementType[])new Object[capacity];
  }
  
  /**
   * @see datastructures.MyCollection#isEmpty
   */
  public boolean isEmpty(){
    return size==0;
  }
  
  /** 
   * @see datastructures.MyCollection#contains
   */
  public boolean contains(ElementType element){
    for(ElementType e: this){
      if(e.equals(element)){
        return true;
      }
    }
    return false;
  }
  
  /**
   * @see datastructures.MyCollection#iterator
   */
  public Iterator<ElementType> iterator(){
    return new InternalIterator();
  }
  
  /**
   * @see datastructures.MyQueue#peek
   */
  public ElementType peek(){
    if(isEmpty()){
      throw new NoSuchElementException("Can't PEEK an empty queue");
    }
    return theData[size-1];
    //OR
    // return theData[0];
    
  }
  
  /**
   * @see datastructures.MyQueue#dequeue
   */
  public ElementType dequeue(){
    if(isEmpty()){
      throw new NoSuchElementException("Can't DEQUEUE an empty queue");
    }
    ElementType top = theData[size-1];
    size--;
    return top;
    
//    //OR
//      ElementType top = theData[0];
//      for(int i=0;i<size-1;i++){
//      theData[i] = theData[i+1];
//      }
//      size--;
//      return top;
    
  }
  
  /**
   * @see datastructures.MyQueue#enqueue
   */
  public void enqueue(ElementType element){
    if (size == capacity) {
      reallocate();
    }
    for(int i=size;i>0;i--){
      theData[i] = theData[i-1];
    }
    theData[0] = element;
    size++;
//    //OR
//      theData[size] = element;
//      size++;
    
  }
  
  /**
   * Helper method to double the  size of theData
   */
  private void reallocate() {
    capacity = 2 * capacity;
    ElementType[] newData = (ElementType[])new Object[capacity];
    System.arraycopy(theData, 0, newData, 0, size);
    theData = newData;
  } 
  
  /**
   * Class to implement Iterator interface needed for method iterator()
   */ 
  private  class InternalIterator implements Iterator<ElementType>{
    /** currentPosition used to traverse elements in the collection*/    
    private int currentPosition;
    
    /**
     * Constructor initializes currentPosition to 0
     */
    public InternalIterator(){
      this.currentPosition=0;
    }
    
    /**
     * @see java.util.Iterator#hasNext
     */     
    public boolean hasNext(){
      return this.currentPosition<size;
    }
    
    /**
     * @see java.util.Iterator#next
     */    
    public ElementType next(){
      if(!hasNext()){
        throw new NoSuchElementException();
      }
      return theData[this.currentPosition++];
    }
    
    /**
     * @see java.util.Iterator#remove
     * @throws UnsupportedOperationException because operation is not supported
     */ 
    public void remove(){
      throw new UnsupportedOperationException("Remove");
    }
  }
}
