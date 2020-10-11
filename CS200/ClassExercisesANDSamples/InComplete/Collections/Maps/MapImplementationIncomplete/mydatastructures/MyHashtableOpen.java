/** Hash table implementation using open addressing.
  * @author Koffman, Wolfgang & Rahal
  */

package mydatastructures;

import java.util.*;

public class MyHashtableOpen < K, V > implements MyHashMap < K, V > {
  // Data Fields
  private Entry < K, V > [] table;
  private static final int START_CAPACITY = 3;
  private static final double LOAD_THRESHOLD = .6;
  private int numKeys;
  
  //WE WILL STORE IT IN "DELETED" SPOTS
  private final Entry < K, V > DELETED = new Entry < K, V > ();
  
  // Constructor
  public MyHashtableOpen() {
    table = new Entry[START_CAPACITY];
  }
  
  /** Returns the number of entries in the map */
  public int size() {
    return numKeys;
  }
  
  /** Returns true if empty */
  public boolean isEmpty() {
    return numKeys == 0;
  }
  
  /** Returns a set containing all keys in Map*/
  public Set<K> keySet(){
    Set<K> keySet = new TreeSet<K>();
    for (int i = 0; i < table.length; i++)
      if(table[i]!=null && !table[i].equals(DELETED))
        keySet.add(table[i].getKey());
    return keySet;
  }
  
  /** Returns a string containing all entries(key,value) in this map*/
  public String toString(){
    String concat="{ ";
    for (K k: this.keySet()){
      concat += (k + "=" + get(k) + " ");
    }
    return concat + "}";
  } 
  
  /** 
   * A helper method which finds either the target key or the first empty 
   * slot in the search chain using linear probing.
   * pre: The table is not full.
   * @param key The key of the target object
   * @return The position of the target or the first empty slot if the 
   * target is not in the table.
   */
  private int find(Object key) {
    // Calculate the starting index.
    int index = key.hashCode() % table.length;
    if (index < 0)
      index += table.length; // Make it positive.
    
    // Increment index until an empty slot is reached or the key is found.
    //ASSUME THAT THERE WILL ALWAYS BE A NULL VALUE
    while ( (table[index] != null) && (!key.equals(table[index].getKey()))) {
      index++;
      // Check for wraparound.
      if (index >= table.length)
        index = 0; // Wrap around.
    }
    return index;
  }
  
  /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
    * post: The size of table is doubled and is an odd integer.
    * Each nondeleted entry from the original table is
    * reinserted into the expanded table.
    * The value of numKeys is reset to the number of items
    * actually inserted;
    */
  private void rehash() {
    // Save a reference to oldTable.
    Entry < K, V > [] oldTable = table;
    // Double capacity of this table.
    table = new Entry[2 * oldTable.length + 1];
    
    // Reinsert all items in oldTable into expanded table.
    numKeys = 0;
    
    for (int i = 0; i < oldTable.length; i++) {
      if ( (oldTable[i] != null) && !oldTable[i].equals(DELETED)) {
        // Rehash entries in expanded table
        put(oldTable[i].getKey(), oldTable[i].getValue());
      }
    }
  }
  
  /** Remove the item with a given key value
    *  @param key The key to be removed
    *  @return The value associated with this key, or null
    *  if the key is not in the table.
    */
  public V remove(Object key) {
    /** COMPLETE ME: ********************************************************************************************
      * PS: use the value returned by the "find" method to decide what to do. 
      * Remove an entry by setting it to DELETED
      * If you delete, rememeber to decrement numKeys by one.
      */  
      int index = find(key);  
      return null;
  }
  
  /** Method get for class HashtableOpen.
    * @param key The key being sought
    * @return the value associated with this key if found;
    * otherwise, null
    */
  public V get(Object key) {
    /** COMPLETE ME: ********************************************************************************************
      PS: use the value returned by the "find" method to decide what to return */
    
    int index = find(key);
    return null;
  }
  
  /** Returns true if parameter value exists in Map as an Entry value*/
  public boolean containsValue(V value){
    /** COMPLETE ME: ********************************************************************************************
      * PS: use an enhanced for loop to iterate over keys similar to the toString method above*/
    return false;
  }
  
  /** Returns true if parameter key exists in Map as an Entry key*/
  public boolean containsKey(K key){  
    /** COMPLETE ME: ********************************************************************************************   
      * PS: use the value returned by the get method to decide what to return */
    return false;
  }
  
  /** Method put for class HashtableOpen.
    * post: This key-value pair is inserted in the
    * table and numKeys is incremented. If the key is already
    * in the table, its value is changed to the argument
    * value and numKeys is not changed. If the LOAD_THRESHOLD
    * is exceeded, the table is expanded.
    * @param key The key of item being inserted
    * @param value The value for this key
    * @return Old value associated with this key if found;
    * otherwise, null
    */
  public V put(K key, V value) {
    /** COMPLETE ME: ********************************************************************************************   
      * PS: based on value returned by "find" method detemine if key is new; if so 
      *  1- insert in correct spot, 
      *  2- increment numKeys by one, 
      *  3- use the code below to check if rehashing is needed,  
         double loadFactor = (double) (numKeys) / table.length;
         if (loadFactor > LOAD_THRESHOLD)
         rehash();
      *  4- and return null
      * Otherwise, replace old value for this key with new one and return old one
      */ 
    return null;
  }
   /** Contains key-value pairs for a hash table. */
  private class Entry < K, V > {
    
    /** The key */
    private K key;
    
    /** The value */
    private V value;
    
    /** Creates a en empty entry.
      */
    public Entry() {
    }
    
    /** Creates a new key-value pair.
      @param key The key
      @param value The value
      */
    public Entry(K key, V value) {
      this.key = key;
      this.setValue( value);
    }
    
    /** Retrieves the key.
      @return The key
      */
    public K getKey() {
      return key;
    }
    
    /** Retrieves the value.
      @return The value
      */
    public V getValue() {
      return value;
    }
    
    /** Sets the value.
      @param val The new value
      @return The old value
      */
    public V setValue(V val) {
      V oldVal = value;
      value = val;
      return oldVal;
    }
  }
}

  
