
package datastructures;

import java.util.*;

/** 
 * Class to implement interface MyQueue as a linked list.
 * 
 * @author Rahal
 * @version 09/16/2016
 */

public class MyLinkedQueueImplementation < ElementType > implements MyQueue < ElementType > {
  
  // Data Fields
  /** The reference to the front of the queue where we dequeue. */
  private Node < ElementType > front;
  
  /** The reference to the rear of the queue where we enqueue. */
  private Node < ElementType > rear;
  
  /** create an empty queue denoted by an empty front = rear node. */  
  public MyLinkedQueueImplementation(){
//COMPLETE ME:  STACK HAD THE FOLLOWING *****************************************************************
    front = new Node < ElementType > ();
  }  
  
  /**
   * @see datastructures.MyCollection#isEmpty
   */
  public boolean isEmpty() {
   //COMPLETE ME: STACK HAD THE FOLLOWING *****************************************************************
    return front.isTerminal();
  }
  
  /** 
   * @see datastructures.MyCollection#contains
   */
  public boolean contains(ElementType element){
  //COMPLETE ME: STACK HAD THE FOLLOWING  ***************************************************************************        
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
  public ElementType peek() {
    //COMPLETE ME: STACK HAD THE FOLLOWING  ********************************************************************
    if (isEmpty()){
      throw new NoSuchElementException("Can't PEEK an empty stack");
    }
    return front.data;
  }
  
  /**
   * @see datastructures.MyQueue#dequeue
   */
  public ElementType dequeue() {
    //COMPLETE ME: STACK HAD THE FOLLOWING  *********************************************************************  
    if (isEmpty()){
      throw new NoSuchElementException("Can't dequeue an empty stack");
    }
    ElementType result = front.data;
    front = front.next;
    return result;
  }
  
  /**
   * @see datastructures.MyQueue#enqueue
   */
  public void enqueue(ElementType element) {
    //COMPLETE ME: STACK HAD THE FOLLOWING *********************************************************************  
    front = new Node < ElementType > (element, front);
  }
  
  
  /** A Node is the building block for a single-linked list. */
  private class Node < ElementType > {
    // Data Fields
    /** The reference to the data. */
    private ElementType data;
    
    /** The reference to the next node. */
    private Node< ElementType >  next;
    
    // Constructors
    /** 
     * Creates a new empty node with null next and data fields.
     */
    private Node() {
      this.data = null;
      this.next = null;
    }    
    /** 
     * Creates a new node with a null next field.
     * @param dataItem The data stored
     */
    private Node(ElementType dataItem) {
      this.data = dataItem;
      this.next = null;
    }
    
    /** 
     * Creates a new node that references another node.
     * @param dataItem The data stored
     * @param nodeRef The node referenced by new node
     */
    private Node( ElementType dataItem, Node < ElementType> nodeRef) {
      this.data = dataItem;
      this.next = nodeRef;
    }
    
    /** 
     * Returns true if the node has null data and next instance fields which
     * is used to designate the "terminal" node in this structure .
     * 
     * @return true if this node is a "terminal" node
     */    
    private boolean isTerminal(){
      return this.data == null && this.next == null;
    }    
  } //end class Node
  
  
  /**
   * Class to implement Iterator interface needed for method iterator()
   */   
  private  class InternalIterator implements Iterator<ElementType>{
    /** currentNode used to traverse elements in the collection*/    
    private Node < ElementType > currentNode;
    
    /**
     * Constructor initializes currentNode to front
     */
    public InternalIterator(){
      this.currentNode=front;
    }
    
    /**
     * @see java.util.Iterator#hasNext
     */    
    public boolean hasNext(){
      return currentNode!=rear;
    }
    
    /**
     * @see java.util.Iterator#next
     */      
    public ElementType next(){
      if(!hasNext()){
        throw new NoSuchElementException();
      }
      ElementType currentElement = currentNode.data;
      currentNode = currentNode.next;
      return currentElement;
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
