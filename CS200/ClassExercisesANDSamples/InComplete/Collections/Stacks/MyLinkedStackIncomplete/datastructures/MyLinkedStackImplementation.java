package datastructures;

import java.util.*;

/** 
 * Class to implement interface MyStack as a linked list.
 * 
 * @author I. Rahal
 * @version 09/16/2016
 */

public class MyLinkedStackImplementation < ElementType > implements MyStack < ElementType > {
  
  // Data Fields
  /** The reference to the first stack node. */
  private Node < ElementType > top;
  
  /** create an empty stack denoted by an empty top node. */  
  public MyLinkedStackImplementation(){
    //COMPLETE ME ***************************************************************************************************
    top = new Node<ElementType>();
  }
  
  /**
   * @see datastructures.MyCollection#isEmpty
   */
  public boolean isEmpty() {
    //COMPLETE ME ***************************************************************************************************
    return top.isTerminal();
  }
  
  /** 
   * @see datastructures.MyCollection#contains
   */
  public boolean contains(ElementType element){
    //COMPLETE ME ***************************************************************************************************
    for(ElementType e: this){
      if(e.equals(element))
        return true;      
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
   * @see datastructures.MyStack#peek
   */
  public ElementType peek() {
    //COMPLETE ME ***************************************************************************************************
    if(isEmpty())
      throw new NoSuchElementException();
    return top.data;
  }
  
  /**
   * @see datastructures.MyStack#pop
   */
  public ElementType pop() {
    //COMPLETE ME ***************************************************************************************************
    if(isEmpty())
      throw new NoSuchElementException();
    ElementType retVal = top.data;
    top = top.next;
    return retVal;
  }
  
  /**
   * @see datastructures.MyStack#push
   */
  public void push(ElementType element) {
    //COMPLETE ME ***************************************************************************************************
    top = new Node<ElementType>(element, top);
  }
  
  /** A Node is the building block for a single-linked list. */
  private class Node < ElementType > {
    // Data Fields
    /** The reference to the data. */
    private ElementType data;
    
    /** The reference to the next node. */
    private Node< ElementType > next;
    
    /** 
     * Creates a new empty node with null next and data fields.
     */
    private Node() {
      this.data = null;
      this.next = null;
    }
    
    /** 
     * Creates a new node with a null next field.
     * 
     * @param dataItem The data stored
     */
    private Node(ElementType dataItem) {
      this.data = dataItem;
      this.next = null;
    }
    
    /** 
     * Creates a new node that references another node.
     * 
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
     * Constructor initializes currentNode to top
     */
    private InternalIterator(){
      this.currentNode=top;
    }
    
    /**
     * @see java.util.Iterator#hasNext
     */  
    public boolean hasNext(){
      return (!currentNode.isTerminal());
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
