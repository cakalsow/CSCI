package mydatastructures;
/** 
 * This class implements some of the methods of the Java ArrayList class
 * @author I Rahal
 * @verion 2014
 */

public class MyArrayList < ExpectedType > implements MyList< ExpectedType >{
  // Data Fields
  /** 
   * The default initial capacity 
   */
  private static final int INITIAL_CAPACITY = 6;
  
  /** 
   * The underlying data array 
   */
  private ExpectedType[] theData;
  
  /** 
   * The current size 
   */
  private int size = 0;
  
  /** 
   * The current capacity 
   */
  private int capacity = 0;
  
  /** 
   * Construct an empty MyArrayList with the default initial capacity
   */
  public MyArrayList() {
    capacity = INITIAL_CAPACITY;
    //theData = new ExpectedType[capacity];
    //theData = new Object[capacity];
    theData = (ExpectedType[])new Object[capacity];
  }
  
 /** 
   * Appends the specified element to the end of this list
   *
   * @param anEtry - The new value to append to the end
   * @return true always
   */
  public boolean add(ExpectedType anEntry) {
    if (size == capacity) {
      reallocate();
    }
    theData[size] = anEntry;
    size++;
    return true;
  }
  
 /** 
   * Get a value in the list based on its index.
   * 
   * Pre: index should be >= 0 and < size
   * @param index - The index of the item desired
   * @return The contents of the List at that index
   * @throws IndexOutOfBoundsException - if pre 
   * condition is false
   */
  public ExpectedType get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("for index : " + index);
    }
    return theData[index];
  }
  
 /** 
   * Set the value in the List based on its index.
   * 
   * Pre: index should be >= 0 and < size
   * @param index - The index of the item desired
   * @param newValue - The new value to store at this position
   * @return The old value at this position
   * @throws IndexOutOfBoundsException - if pre 
   * condition is false
   */
  public ExpectedType set(int index, ExpectedType newValue) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("for index : " + index);
    }
    ExpectedType oldValue = theData[index];
    theData[index] = newValue;
    return oldValue;
  }
  
 /** 
   * Remove an entry based on its index
   * 
   * Pre: index should be >= 0 and < size
   * @param index - The index of the entry to be removed
   * @return The value removed
   * @throws IndexOutOfBoundsException - if pre 
   * condition is false
   */
  public ExpectedType remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("for index : " + index);
    }
    ExpectedType returnValue = theData[index];
    for (int i = index + 1; i < size; i++) {
      theData[i - 1] = theData[i];
    }
    size--;
    return returnValue;
  }
  
 /** 
   * Get the current size of the List
   * 
   * @return The current size of the List
   */
  public int size() {
    return size;
  }
  
 /** 
   * Add an entry to the list inserting it before the
   * item at the specified index.
   * Pre: index should be >= 0 and <= size
   * @param index - The location of the inserted item (between 0 and size inclusive)
   * @param theValue - The value to be inserted
   * @return true 
   * @throws IndexOutOfBoundsException i- if pre 
   * condition is false
   */
  public boolean add(int index,ExpectedType anEntry) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("for index : " + index);
    }    
    if (size == capacity) {
      reallocate();
    }
    for (int i = size; i > index; i--) {
      theData[i] = theData[i-1];
    }
    
    size++;
    theData[index] = anEntry;
    return true;
  }
  
  /** 
   * Allocate a new array to hold the directory
   */
  private void reallocate() {
    capacity = 2 * capacity;
    ExpectedType[] newData = (ExpectedType[]) new Object[capacity];
    System.arraycopy(theData, 0, newData, 0, size);
    theData = newData;
  }
  
  
  
}
