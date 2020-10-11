package worker;

import java.io.Serializable;

/** 
 * HourlyEmployee is a class for objects that extends HourlyWorker and implements Employee.
 * 
 * @author Kayli and Channa
 */

public class HourlyEmployee extends HourlyWorker implements Employee
{

  private double hourlyPay;
   //First Constructor that takes in name
  public HourlyEmployee(String name)
  {
    super(name);
    hourlyPay = 0.0;
  }
  //Second constructor that takes in hours and name
  public HourlyEmployee(String name, int hours)
  {
    super(name, hours);
    hourlyPay = 0.0;
  }
  //Third constructor that takes in name, hours and hourlyPay
  public HourlyEmployee(String name, int hours, double hourlyPay)
  {
   super(name, hours);
   this.hourlyPay = hourlyPay;
  }
  
  public double getHourlyPay()
  {
    return hourlyPay;
  }
  //sets the hours to pay 
  public void setHourlyPay(double pay) throws IllegalArgumentException
  {
  this.hourlyPay= pay;  
  }
    public String toString(){
      return "Hourly Employee";
    }
    
    public double getMonthlyPay()
    {
     return hourlyPay;
    }
}