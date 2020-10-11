/** A recursive linked list class with recursive methods.*/
package mystructures;

import java.util.*;

@SuppressWarnings("unchecked")
public class DLinkedListRec < E > implements SimpleList<E> {
  
  /** The list head */
  private Node < E > head;
  
  public DLinkedListRec(){
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
  
  public boolean remove(E outElement){
    return head.remove(outElement);
  }  
  
  public E get(int index){
    if(index>= size() || index <0)
      throw new IllegalArgumentException();
    else
      return head.get(index);
  }
  
  public String toStringReverse() {
    Node<E> last = head;
    while(last.element!=null){
      last = last.next;
    }   
    return last.toStringReverse();
    
  }  
  
  public int indexOf(E element){
    return head.indexOf(element);
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
  
  
  public ListIterator < E > iterator(){
    return new InternalListIterator();
  }
  
  private class Node < E > {
    /** The reference to the data element. */
    private E element;
    
    /** The reference to the next node. */
    private Node<E> next;
    
    /** The reference to the previous node. */
    private Node<E> prev;
    
    // Constructors
    /** Creates a new node with a null next and element fields*/
    private Node() {
      element = null;
      next =null;
      prev = null;
    }
    
    /** Creates a new node that references null.
      @param element The data stored
      */
    private Node(E element) {
      this.element = element;
      next =null;
      prev =null;
    }
    
    /** Creates a new node that references another node.
      @param element The data stored
      @param next The next node referenced by new node
      @param prev The previous node referenced by new node
      */
    private Node(E element, Node < E > next, Node<E> prev) {
      this.element = element;
      this.next = next;
      this.prev = prev;
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
        return this.element + "<->" + this.next.toString();
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
        this.next.prev = this;
      }
      else
        this.next.append(element); // Add to rest of list.
    }
    
    private boolean remove( E outElement){
      if(this.element==null)
        return false;
      else if (outElement.equals(this.element)){
        this.element = this.next.element;
        this.next = this.next.next;
        if(this.next!=null)
          this.next.prev = this; 
        return true;
      }
      else
        return this.next.remove(outElement);
    } 
    
    private E get(int index){     
      if(index == 0)
        return this.element;
      else
        return this.next.get(index-1);
    }
    
    private String toStringReverse() {
      if (this.prev==null)
        return ""+this.element;
      else if (this.element==null)
        return this.prev.toStringReverse();
      else
        return this.element + "  " + this.prev.toStringReverse();
    }  
    
    private int indexOf(E element){
      return this.indexOf(element,0);
    }   
    
    private int indexOf(E element,int index){
      if (this.element == null)
        return -1;
      else if (element.equals(this.element))
        return index;
      else
        return this.next.indexOf(element,index+1);
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
  }//end inner class InternalIteratorV2  
}
