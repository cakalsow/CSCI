package worker;
import java.io.Serializable;

/** 
 * SalariedEmployee is a class for objects that extends HourlyWorker.
 * 
 * @author Kayli and Channa
 */

public class SalariedEmployee implements Employee  
{
  //defining variables from worker and Employee
  private String name;
  
  private double monthlySalary;
  //First Constructor that takes in name
  public SalariedEmployee(String name)
  {
    this.name = name;
    monthlySalary = 0.0;
  }
  //Second constructor that takes in monthly pay and name
  //Third constructor that takes in name, hours and monthlySalary
  public SalariedEmployee(String name, double monthlySalary)
  {
    this.name = name;
    this.monthlySalary = monthlySalary;
  }
  //Sets monthlypay to the variable pay
  public double setMonthlyPay(double pay)
  {
    return (this.monthlySalary = pay);
  }
  //returns the monthlyPay
  public double getMonthlyPay(){
    
    return monthlySalary;
  }
  //gets the name from worker interface
  public String getName(){
    return this.name;
  }
  public boolean equals(Object otherObject){
    Worker aWorker = (Worker) otherObject;
    
    return (this.name.equals(aWorker.getName()));
    
  }
  public String toString(){
    return "Salaried Employee";
  }
}