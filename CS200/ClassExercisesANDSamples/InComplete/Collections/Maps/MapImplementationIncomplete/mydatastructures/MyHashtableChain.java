package mydatastructures;
import java.util.*;

/** Hash table implementation using chaining.
  *   @author Koffman, Wolfgang & Rahal
  * */

public class MyHashtableChain < K, V > implements MyHashMap < K, V > {
  /** The table */
  private LinkedList < Entry < K, V >> [] table;
  
  /** The number of keys */
  private int numKeys;
  
  /** The capacity */
  private static final int CAPACITY = 2;
  
  /** The maximum load factor */
  private static final double LOAD_THRESHOLD = 2.0;
  
  // Constructor
  public MyHashtableChain() {
    table = new LinkedList[CAPACITY];
  }
  
  /** Returns the number of entries in the map */
  public int size() {
    return numKeys;
  }
  
  /** Returns true if empty */
  public boolean isEmpty() {
    return numKeys == 0;
  }
  
  /** Returns true if parameter value exists in Map as an Entry value*/
  public boolean containsValue(V value){
    for (K k: keySet()){
      if(get(k).equals(value))
        return true;
    }
    return false;
  }
  
  /** Returns true if parameter key exists in Map as an Entry key*/
  public boolean containsKey(K key){  
    return (this.get(key)!=null);
  }
  
  
  /** Returns a set containing all keys in Map*/
  public Set<K> keySet(){
    Set<K> keySet = new TreeSet<K>();
    for (int i = 0; i < table.length; i++)
      if(table[i]!=null){
      for(int j = 0; j<table[i].size();j++){
        keySet.add(table[i].get(j).getKey());
      }
    }
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
  
  /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
    post: the size of table is doubled and is an
    odd integer. Each non-deleted entry from the original
    table is reinserted into the expanded table.
    The value of numKeys is reset to the number of items
    actually inserted; numDeletes is reset to 0.
    */
  public void rehash() {
    // Save a reference to oldTable
    LinkedList < Entry < K, V >> [] oldTable = table;
    // Double capacity of this table
    table = new LinkedList[2 * oldTable.length + 1];
    
    // Reinsert all items in oldTable into expanded table.
    numKeys = 0;
    for (int i = 0; i < oldTable.length; i++) {
      if (oldTable[i] != null) {
        for (Entry < K, V > nextEntry : oldTable[i]) {
          // Insert entry in expanded table
          put(nextEntry.key, nextEntry.value);
        }
      }
    }
  }
  
  /** Method get for class HashtableChain.
    @param key The key being sought
    @return The value associated with this key if found;
    otherwise, null
    */ 
  public V get(Object key) {
    int index = key.hashCode() % table.length;
    if (index < 0)
      index += table.length;
    //COMPLETE ME *****************************************************************************************************
    return null;
  }
  
  /** Method put for class HashtableChain.
    post: This key-value pair is inserted in the
    table and numKeys is incremented. If the key is already
    in the table, its value is changed to the argument
    value and numKeys is not changed.
    @param key The key of item being inserted
    @param value The value for this key
    @return The old value associated with this key if
    found; otherwise, null
    */
  public V put(K key, V value) {
    int index = key.hashCode() % table.length;
    if (index < 0)
      index += table.length;
    //COMPLETE ME *****************************************************************************************************
    return null;
  }
  
  
  public V remove(Object key) {
    int index = key.hashCode() % table.length;
    if (index < 0)
      index += table.length;
    //COMPLETE ME *****************************************************************************************************
    return null; // Key not in table
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
      this.value = value;
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
