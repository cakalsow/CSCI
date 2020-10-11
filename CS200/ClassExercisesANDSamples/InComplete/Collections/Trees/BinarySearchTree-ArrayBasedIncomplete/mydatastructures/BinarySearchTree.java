package mydatastructures;
@SuppressWarnings("unchecked")
public class BinarySearchTree < E extends Comparable <E> > implements BSTInterface <E>{
  
  /* The default initial capacity*/
  private static final int INITIAL_CAPACITY = 6;
  
  /* The underlying data array*/
  private E[] elements;
  
  /* The current size*/
  private int size = 0;
  
  /* The current capacity*/
  private int capacity = 0;
  
  public BinarySearchTree() {
    capacity = INITIAL_CAPACITY;
    elements = (E[]) new Comparable[capacity];
  }
  
  public boolean contains(E target) {
    //calls recursive version starting index 0
    return contains(target, 0);
  }
  
  private boolean contains(E target, int currentIndex) {
    //COMPLETE ME ***************************************************************************************************
    /**
     * Logic:
     * 1- if currentIndex exceeds capacity then target isn't in array
     * 2- if element at currentIndex is null then target isn't in array
     * 3- otherwise compare target to element at currentIndex and either return true or call method starting index
     *    of left or right child
     *    PS: leftChildIndex = 2*currentIndex + 1 AND rightChildIndex = 2*currentIndex + 2
     */
    return false;
  }
  
  public boolean add(E element) {
    //calls recursive version starting index 0
    boolean answer = add(element,0);
    if (answer)
      size++;
    return answer;
  }
  
  private boolean add(E element, int currentIndex) {
    //COMPLETE ME ***************************************************************************************************
    //logic similar to contains but make sure to call reallocate when currentIndex>=capacity
    return false;
  }
  
  public E remove (E element) {
    //calls recursive version starting index 0
    E answer = remove(element,0);
    if (answer!=null)
      size--;
    return answer;
  }
  
  private E remove (E element, int currentIndex) {
    //COMPLETE ME ***************************************************************************************************
    /**
     * Again logic similar to contains but need to consider different actions when a match is found
     * 1- match has no children
     * 2- match has one children
     * 3- match has two children
     */ 
    return null;
  }
  
  
  private int getIndexOfReplacementElement(int currentIndex){
    //COMPLETE ME ***************************************************************************************************
    //finds the largest in the left sub-tree
    return -1;
  }
  
  //prints the elements in the array used to store the tree
  public String toString() {
    String allElements = "";
    for (int index=0; index<capacity;index++){
      allElements += elements[index] + " (" + index + "), ";
    }
    return allElements;
  }
  
  /** 
   * Allocate a new array to hold the directory
   */
  private void reallocate() {
    int oldCapacity = capacity;
    capacity = 2 * oldCapacity;
    E[] newElements = (E[]) new Comparable[capacity];
    System.arraycopy(elements, 0, newElements, 0, oldCapacity);
    elements = newElements;
  }  
}
