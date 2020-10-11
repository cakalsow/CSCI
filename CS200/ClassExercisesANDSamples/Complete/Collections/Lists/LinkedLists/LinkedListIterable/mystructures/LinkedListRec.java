/** A recursive linked list class with recursive methods.*/
package mystructures;

import java.util.*;

@SuppressWarnings("unchecked")
public class LinkedListRec < E > implements SimpleList<E> {
  
  /** The list head */
  private Node < E > head;
  
  public LinkedListRec(){
    /** The last node in the list is always the empty node ... head initially points to the empty node  */
    head = new Node<E>(); 
  }
  
  public int size() {
    return head.size();
  }
  
  public String toString() {
    return head.toString();
  } 
  
  public boolean contains(E element) {
    return head.contains(element); 
  }  
  
  public void append(E element) {
    head.append(element); 
  }
 
  
  public E get(int index){
    if(index>= size() || index <0)
      throw new IllegalArgumentException();
    return head.get(index);
  }
  
  public Iterator < E > iterator(){
    return new InternalIteratorV2();
  }  
    /** A Node is the building block for a single-linked list. */
  private class Node < E > {
    /** The reference to the data element. */
    private E element;
    
    /** The reference to the next node. */
    private Node<E> next;
    
    // Constructors
   /** 
     * Creates a new empty node with null next and element fields.
     */
    private Node() {
      this.element = null;
      this.next =null;
    }
    
    /** 
     * Creates a new node with a null next field.
     * @param element The data stored
     */
    private Node(E element) {
      this.element = element;
      next =null;
    }
    
    /** Creates a new node that references another node
      * @param element The data stored
      * @param next The node referenced by new node
      */
    private Node(E element, Node < E > next) {
      this.element = element;
      this.next = next;
    }
    
    /** 
     * Returns true if the node has null data and next instance fields which
     * is used to designate the "terminal" node in this structure .
     * 
     * @return true if this node is a "terminal" node
     */    
    private boolean isTerminal(){
      return this.element == null && this.next == null;
    }
    
    private int size() {
      if (this.isTerminal())
        return 0;
      else
        return 1 + this.next.size();
    }     
    
    public String toString() {
      if (this.isTerminal())
        return "|TERMINAL|";     
      else
        return this.element + "->" + this.next.toString();
    }   
    
    private boolean contains(E element) {
      if (this.isTerminal())
        return false;
      else if (element.equals(this.element))
        return true;
      else
        return this.next.contains(element);
    }   
    
    private void append( E element) {
      if (this.isTerminal()){
        this.element = element;
        this.next = new Node < E > ();
      }
      else
        this.next.append(element); // Add to rest of list.
    }
    
    
    private E get(int index){     
      if(this.isTerminal())
        return null;
      else if(index == 0)
        return this.element;
      else
        return this.next.get(index-1);
    }
   
    
  } //end class Node

/*
   * ******************************************************************************************************************
   * First Internal Iterator Class
   * ******************************************************************************************************************
   * THIS ITERATOR CLASS USES currentNode (AN INSTANCE VARIABLE OF TYPE NODE) TO ITERATE OVER THE LIST 
   * TO CHECK YOUR WORK: Add an iterator() method to the outer class which returns an instance of this class and then 
   * run driverr
   */    
  private class InternalIteratorV1 < E > implements Iterator < E > {
    
    /** A reference to the index of the current item. */
    Node<E> currentNode;
    
    public InternalIteratorV1() {
      currentNode =  (Node<E>)head;
    }
    
    /** Indicate whether movement forward is defined.
      @return true if call to next will not throw an exception
      */
    public boolean hasNext() {
      return currentNode.element != null;
    }
    
    /** Move the iterator forward and return the next item.
      @return The next item in the list
      @throws NoSuchElementException if there is no such object
      */
    public E next() {
      if(!hasNext()){
        throw new NoSuchElementException();
      }
      E elementToReturn = currentNode.element;
      currentNode = currentNode.next;
      return elementToReturn;
    } 
    
    public void remove() {
      throw new UnsupportedOperationException("Can't remove using iterators");
    }
  } //end inner class InternalIteratorV1
  
  /*
   * ******************************************************************************************************************
   * Second Internal Iterator Class
   * ******************************************************************************************************************
   * THIS ITERATOR CLASS USES currentIndex (AN INSTANCE VARIABLE OF TYPE int) ALONG WITH THE get METHOD TO 
   * ITERATE OVER THE LIST 
   * TO CHECK YOUR WORK: Change the iterator() method in the outer class to return an instance of this class and then 
   * run driver
   */   
  private class InternalIteratorV2 < E > implements Iterator < E > {
    
    /** A reference to the index of the current item. */
   int index;
    
    public InternalIteratorV2() {
      index = 0;
    }
    
    /** Indicate whether movement forward is defined.
      @return true if call to next will not throw an exception
      */
    public boolean hasNext() {
      return index < size();
    }

    /** Move the iterator forward and return the next item.
      @return The next item in the list
      @throws NoSuchElementException if there is no such object
      */
    public E next() {
      if(!hasNext()){
        throw new NoSuchElementException();
      }
      E elementToReturn = (E) get(index);
      index++;
      return elementToReturn;
    } 
    
    public void remove() {
      throw new UnsupportedOperationException("Can't remove using iterators");
    }
  }//end inner class InternalIteratorV2   
}
