package mydatastructures;
/** 
 * Class for a binary tree that stores type E objects.
 *   @author Imad Rahal
 */

public interface BSTInterface < E extends Comparable<E> > {
    
  public String preOrderTraverse() ;
  
  public String inOrderTraverse() ;
  
  public String postOrderTraverse();
  
  public String toString() ;
  
  public boolean contains(E element);

  public boolean add(E newElement);
  
}
