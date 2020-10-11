package worker;
import java.io.Serializable;

/** 
 * HourlyWorker is a class for objects that implements Worker.
 * 
 * @author Kayli and Channa
 */

public abstract class HourlyWorker implements Worker  
{
  //takes the worker interface variables and defines them here
  private String name;
  
  private int hours;
  //first constructor takes in name
  public HourlyWorker(String name)
  {
   this.name = name;
   hours = 0;
  }
  //Second constructor that takes in hours and name
  public HourlyWorker(String name, int hours)
  {
  this.name = name;
  this.hours = hours;
  }

  public int getHours()
  {
   return this.hours; 
  }
  //adds the hours to the tests while making sure it isnt below zero
  public void addHours(int hoursAdded) throws IllegalArgumentException
  {
    if (hoursAdded < 0){
      throw new IllegalArgumentException("Hours can't be below zero");
    }
      else{
    this.hours= hours + hoursAdded;
  }
    }
  public void resetHours()
  {
    this.hours = 0;
  }
  
    public String getName(){
    return this.name;
  }
    public boolean equals(Object otherObject){
      Worker aWorker = (Worker) otherObject;
      
      return (this.name.equals(aWorker.getName()));
    }
}