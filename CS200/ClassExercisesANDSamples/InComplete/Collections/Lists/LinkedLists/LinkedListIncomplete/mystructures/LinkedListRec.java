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
    return 0;
  }
  
  public String toString() {
    return null;
  } 
  
  public boolean contains(E element) {
    return false; 
  }  
  
  public void append(E element) {
   
  }
  
  //******************************* ADDITIONAL METHODS TO COMPLETE *************************
  
  public boolean remove(E outElement){
    if (this.isTerminal())
    {
     return false; 
    }
    else if (outElement.equals(this.element))
    {
      this.element = this.next.element;
      this.next = this.next.next;
      return true;
    }
    else
    {
     return this.next.remove(outElement); 
    }
  }  
  
  public E get(int index){
    if (index >= size)  
    return null;
  }
  
  public String toStringReverse(){
    //COMPLETE ME **************************************************************************
    return null;
  }
  
  public int indexOf(E element){
    //COMPLETE ME **************************************************************************
    return -1;
  }
  
  public void appendAll(SimpleList<E> l){
    //COMPLETE ME **************************************************************************
 
  }
  
  public boolean isSubList(SimpleList<E> potentialSubList){
    //COMPLETE ME **************************************************************************
    return false;
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
     return 0;
    }     
    
    public String toString() {
     return null;
    }   
    
    private boolean contains(E element) {
      return false;
    }   
    
    private void append( E element) {
      
    }
    
    private boolean remove( E outElement){
      //COMPLETE ME **************************************************************************      
      return false;
    } 
    
    private E get(int index){     
      //COMPLETE ME **************************************************************************      
      return null;
    }
    
    private String toStringReverse() {
      //COMPLETE ME **************************************************************************
      return null;
    }
    
    private int indexOf(E element,int index){
      //COMPLETE ME **************************************************************************
     return -1;
    }    
    
  } //end class Node
}
