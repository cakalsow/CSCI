/** An interface for HashMap
 *  @author Koffman, Wolfgang & Rahal
 */
package mydatastructures;
import java.util.*;

public interface MyHashMap < K, V > {

  public int size();

  public boolean isEmpty();
  
  public Set<K> keySet();  
  
  public String toString();
  
  public V remove(Object key);
  
  public V get(Object key);  
  
  public boolean containsValue(V value);
  
  public boolean containsKey(K key);
  
  public V put(K key, V value);



}
