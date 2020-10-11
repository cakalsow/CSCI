package mydatastructures;
/** 
 * Class for a binary search tree that stores type E objects.
 *   @author Imad Rahal
 * 
 */

public interface BSTInterface < E extends Comparable > { 
  
  public String toString() ;
  
  public boolean contains(E element);
  
  public boolean add(E element);
  
  public E remove (E element);
}
