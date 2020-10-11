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
  public boolean remove(E outElement){
    return head.remove(outElement);
  }   
  
  public E get(int index){
    if(index>= size() || index <0)
      throw new IllegalArgumentException();
    return head.get(index);
  }
  
  public String toStringReverse(){
    return head.toStringReverse();
  }
  
  public int indexOf(E element){
    return head.indexOf(element,0);
  }
  
  public void appendAll(SimpleList<E> l){
    for(int i=0;i<l.size();i++){
      this.append(l.get(i));
    }
  }
  
  public boolean isSubList(SimpleList<E> potentialSubList){
    for(int i=0;i<potentialSubList.size();i++){
      if(!this.contains(potentialSubList.get(i))){
        return false;
      }
    }
    return true;
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
    
    private boolean remove( E outElement){
      if(this.isTerminal())
        return false;
      else if (outElement.equals(this.element)){
        this.element = this.next.element;
        this.next = this.next.next;
        return true;
      }
      else
        return this.next.remove(outElement);
    } 
       
    private String toStringReverse() {
      if (this.isTerminal())
        return "";     
      else
        return this.next.toStringReverse() + " " + this.element;
    }
    
     private int indexOf(E element,int index){
      if (this.isTerminal())
        return -1;
      else if (element.equals(this.element))
        return index;
      else
        return this.next.indexOf(element,index+1);
    }    
    
//     private int indexOf(E element){
//      if (this.isTerminal())
//        return -1;
//      else if (element.equals(this.element))
//        return 0;
//      else
//        return 1+this.next.indexOf(element);
//    }    
  } //end class Node    
  
} 

