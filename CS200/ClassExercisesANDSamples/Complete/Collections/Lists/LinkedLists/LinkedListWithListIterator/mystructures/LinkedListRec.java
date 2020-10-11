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
    return head.toString() + "//";
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
    else
      return head.get(index);
  }
  
  public Iterator < E > iterator(){ 
    return new InternalListIterator(); 
  }    
  
  private class Node < E > {
    /** The reference to the data element. */
    private E element;
    
    /** The reference to the next node. */
    private Node<E> next;
    
    // Constructors
    /** Creates a new node with a null next and element fields*/
    private Node() {
      element = null;
      next =null;
    }
    
    /** Creates a new node that references null.
      @param element The data stored
      */
    private Node(E element) {
      this.element = element;
      next =null;
    }
    
    /** Creates a new node that references another node.
      @param element The data stored
      @param next The node referenced by new node
      */
    private Node(E element, Node < E > next) {
      this.element = element;
      this.next = next;
    }
    
    private int size() {
      if (this.element == null)
        return 0;
      else
        return 1 + this.next.size();
    }     
    
    public String toString() {
      if (this.element== null)
        return "";     
      else
        return this.element + "->" + this.next.toString();
    }   
    
    private boolean contains(E element) {
      if (this.element == null)
        return false;
      else if (element.equals(this.element))
        return true;
      else
        return this.next.contains(element);
    }   
    
    private void append( E element) {
      if (this.element== null ){
        this.element = element;
        this.next = new Node < E > ();
      }
      else
        this.next.append(element); // Add to rest of list.
    }
    
    private E get(int index){     
      if(index == 0)
        return this.element;
      else
        return this.next.get(index-1);
    }
     
    
  } //end inner class Node
  
  
  private class InternalListIterator < E > implements ListIterator < E > {
    
    /** A reference to the index of the current item. */
    int index;
    
    public InternalListIterator() {
      index = 0;
    }
    public boolean hasPrevious() {
      return index > 0 ;
    }
    
    public int previousIndex(){
      if(!hasPrevious())
        throw new NoSuchElementException();
      return index-1;
    }
    
    public E previous() {
      if(!hasPrevious())
        throw new NoSuchElementException();
      E elementToReturn = (E) get(index-1);
      index--;
      return elementToReturn;
    }     
    
    public boolean hasNext() {
      return index < size();
    }
    
    public int nextIndex(){
      return index;
    }    
    public E next() {
      if(!hasNext())
        throw new NoSuchElementException();
      E elementToReturn = (E) get(index);
      index++;
      return elementToReturn;
    } 
       
    public void set(E e) {
      throw new UnsupportedOperationException("Can't set using iterators");
    }       
    public void add(E e) {
      throw new UnsupportedOperationException("Can't add using iterators");
    }    
    
    public void remove() {
      throw new UnsupportedOperationException("Can't remove using iterators");
    }
  }//end inner class InternalListIterator  
}
