package ckeestructures;

import java.util.*;
import zhstructures.*;

public class CKEELinkedQueue<ElementType> implements ZHQueue<ElementType>
{
  /**
   * The number of elements in this queue.
   */
  protected int size = 0 ;
  /**
   * A reference to the first node in this queue.
   */
  protected QueueNode front;
  /**
   * A reference to the last node in this queue.
   */
  protected QueueNode rear;
  
  /**
   * Creates a new empty queue.
   */
  public CKEELinkedQueue() {

    this.front = new QueueNode();
    this.rear = front;
 
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#peek()
   */
  public ElementType peek() {
    if (isEmpty()){
    
      throw new NoSuchElementException("Can't PEEK an empty queue.");
    }
    return front.getElement();
  }
  
  
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#pop()
   */
  public ElementType dequeue() {
    if (isEmpty()){
      throw new NoSuchElementException("Can't DEQUEUE an empty queue.");
    }
    ElementType result = this.front.getElement();
    this.front = this.front.getNext();
    this.size = this.size  -1;
   
    return result;
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#push(java.lang.Object)
   */
  public void enqueue(ElementType element) {
   this.rear.setElement(element);
   this.rear.setNext(new QueueNode());
   this.rear = this.rear.getNext();
   
    this.size = this.size+1;
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#contains(java.lang.Object)
   */
  public boolean contains(ElementType element) {
    for(ElementType e: this){
      if(e.equals(element)){
        return true;
      }
    }
    return false;
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#isEmpty()
   */
  public boolean isEmpty() {
    if (this.front.isTerminal() && this.rear.isTerminal())
    {
      return true;
    }
else
{
    return false;
  }
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#size()
   */
  public int size() {
    return this.size;
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#iterator()
   */
  public Iterator<ElementType> iterator() {
    return this.front.iterator();
  }
  
  /**
   * Class implementing nodes for this queue.
   * 
   * Inherited methods:
   *   boolean contains()
   *   boolean isEmpty()
   *   int size()
   *   Iterator<ElementType> iterator()
   *   ElementType getElement()
   *   void setElement(ElementType element)
   *   QueueNode getNext()
   *   void setNext(QueueNode next)
   */
  protected class QueueNode
    extends ZHOneWayListNode<ElementType, QueueNode> {
    
    /**
     * Creates a new empty node.
     */
    protected QueueNode() {
      super();
    }
    
    /**
     * Creates a new node with the specified data element and next node.
     * 
     * @param element the data element for the new node
     * @param next the next node for the new node
     */
    protected QueueNode(ElementType element, QueueNode next) {
      super(element, next);
    }
  }
}