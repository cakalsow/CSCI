/*
 * File: <CKEE>LinkedStack.java
 */
package ckeestructures;

import java.util.*;
import zhstructures.*;

/**
 * Class implementing a ZHStack using an internal
 * one-way linked structure/node.
 * 
 * @author I. Rahal, J. A. Whitford Holey, and Channa Kalsow
 * @version 10/09/20
 */
public class CKEELinkedStack<ElementType> implements ZHStack<ElementType> {
  
  /**
   * The number of elements in this stack.
   */
  protected int size = 0;
  /**
   * A reference to the top node in this stack.
   */
  protected StackNode top;
  
  /**
   * Creates a new empty stack.
   */
  public CKEELinkedStack() {
    this.top = new StackNode();
  
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHStack#peek()
   */
  public ElementType peek() {
    if (isEmpty()){
      throw new NoSuchElementException("Can't PEEK an empty stack.");
    }
    return this.top.getElement();
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHStack#pop()
   */
  public ElementType pop() {
    if (isEmpty()){
      throw new NoSuchElementException("Can't POP an empty stack.");
    }
 ElementType result = this.top.getElement();
    this.top =top.getNext();
    this.size--;
    return result;
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHStack#push(java.lang.Object)
   */
  public void push(ElementType element) {
    StackNode temp = this.top;
    top = new StackNode();
    this.top.setElement(element);
    this.top.setNext(temp);
    this.size++;
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
  return this.top.isTerminal();
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
    return this.top.iterator();
  }
  
  /**
   * Class implementing nodes for this stack.
   * 
   * Inherited methods:
   *   boolean contains()
   *   boolean isEmpty()
   *   int size()
   *   Iterator<ElementType> iterator()
   *   ElementType getElement()
   *   void setElement(ElementType element)
   *   StackNode getNext()
   *   void setNext(StackNode next)
   */
  protected class StackNode
    extends ZHOneWayListNode<ElementType, StackNode> {
    
    /**
     * Creates a new empty node.
     */
    protected StackNode() {
      super();
    }
    
    /**
     * Creates a new node with the specified data element and next node.
     * 
     * @param element the data element for the new node
     * @param next the next node for the new node
     */
    protected StackNode(ElementType element, StackNode next) {
      super(element, next);
    }
  }
}
