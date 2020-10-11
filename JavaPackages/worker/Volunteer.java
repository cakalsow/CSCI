package worker;

import java.io.Serializable;

/** 
 * Volunteer is a class for objects that extends HourlyWorker.
 * 
 * @author Kayli and Channa
 */

public class Volunteer extends HourlyWorker  
{
// constructor that gets the name from abstract class HourlyWorker using a super.
  public Volunteer(String name)
  {
    super(name);

  }
  // Secound constructor that takes the hours from HourlyWorker.
  public Volunteer(String name, int hours)
  {
    super(name, hours);
  }
  //ToString for the the Volunteertest.
   public String toString(){
      return "Volunteer";
   }
}