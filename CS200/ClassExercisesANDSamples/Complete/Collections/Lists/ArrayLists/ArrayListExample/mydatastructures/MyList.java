package mydatastructures;
/** 
 * This class implements some of the methods of the Java ArrayList class
 * @author I Rahal
 * @verion 2015
 */

public interface MyList < ExpectedType >{
  /** 
   * Appends the specified element to the end of this list
   *
   * @param anEtry - The new value to append to the end
   * @return true always
   */
  public boolean add(ExpectedType anEntry);
  
  /** 
   * Get a value in the list based on its index.
   * 
   * Pre: index should be >= 0 and < size
   * @param index - The index of the item desired
   * @return The contents of the List at that index
   * @throws IndexOutOfBoundsException - if pre 
   * condition is false
   */
  public ExpectedType get(int index);
  
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
  public ExpectedType set(int index, ExpectedType newValue) ;
  
  /** 
   * Remove an entry based on its index
   * 
   * Pre: index should be >= 0 and < size
   * @param index - The index of the entry to be removed
   * @return The value removed
   * @throws IndexOutOfBoundsException - if pre 
   * condition is false
   */
  public ExpectedType remove(int index) ;
  
  /** 
   * Get the current size of the List
   * 
   * @return The current size of the List
   */
  public int size() ;
  
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
  public boolean add(int index,ExpectedType anEntry);
}
