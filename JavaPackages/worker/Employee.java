package worker;
import java.io.Serializable;

/** 
 * Employee is an interface for objects that represents class hierarchy.
 * 
 * @author Kayli and Channa
 */
public interface Employee extends Worker  
{
  public double getMonthlyPay();
}