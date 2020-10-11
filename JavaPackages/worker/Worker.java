package worker;
import java.io.Serializable;

/** 
 * Worker is an interface that extends Serializable from Java.io.
 * 
 * @author Kayli and Channa
 */

public interface Worker extends Serializable  
{
  /** 
 * Methods in the interface that will be implemented into HourlyWorker.
 */
  public String getName();
  
  public boolean equals(Object otherObject);
  
  public String toString();  
  
}