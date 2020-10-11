/**
 * SalariedEmployeeTest.java
 */

import worker.*;
import org.junit.*;

public class SalariedEmployeeTest {
  private SalariedEmployee noPaySalariedEmployee, withPaySalariedEmployee;
  
  @Before
  public void init(){
    // creates SalariedEmployee workers with name
    noPaySalariedEmployee=new SalariedEmployee("noPaySalariedEmployee");
    withPaySalariedEmployee=new SalariedEmployee("withPaySalariedEmployee", 10.0);
  }
  
  /**
   * test that the constructor in class Volunteer sets the name and hours fields to the expected 
   * initial values and that the toString method returns the String "SalariedEmployee" 
   */
  @Test
  public void testSalariedEmployeeConstructor(){
    Assert.assertTrue("noPaySalariedEmployee should have given name",noPaySalariedEmployee.getName().equals("noPaySalariedEmployee"));
    Assert.assertTrue("Salary in noPaySalariedEmployee should be 0 initially", noPaySalariedEmployee.getMonthlyPay() == 0);
    Assert.assertTrue("toString should return 'SalariedEmployee'",noPaySalariedEmployee.toString().equals("Salaried Employee"));
    Assert.assertTrue("Salary should be changed to 5.0", noPaySalariedEmployee.setMonthlyPay(5.0) == 5.0);
    
    Assert.assertTrue("withPaySalariedEmployee should have given name",withPaySalariedEmployee.getName().equals("withPaySalariedEmployee"));
    Assert.assertTrue("Salary in withPaySalariedEmployee should be 10.0 initially", withPaySalariedEmployee.getMonthlyPay() == 10.0);
    Assert.assertTrue("toString should return 'SalariedEmployee'",withPaySalariedEmployee.toString().equals("Salaried Employee"));    
  }  
  

  
  /**
   * test that method equals returns true for different Workers with the same names  
   */  
  @Test
  public void testEqualsDifferentWorkersSameNames(){
    noPaySalariedEmployee=new SalariedEmployee("test");
    withPaySalariedEmployee=new SalariedEmployee("test", 10.0);
    Assert.assertTrue("Volunteers should be equal",noPaySalariedEmployee.equals(withPaySalariedEmployee));
    
    Assert.assertTrue("Volunteer and HourlyEmployee should be equal",noPaySalariedEmployee.equals(new HourlyEmployee("test",0,0)));
    
    Assert.assertTrue("Volunteer and SalariedEmployee should be equal",noPaySalariedEmployee.equals(new SalariedEmployee("test",0)));
  }
  
  /**
   * test that method equals returns false for Workers with different names  
   */  
  @Test
  public void testEqualsDifferentWorkersDifferentNames(){
    Assert.assertFalse("Volunteers should not be equal",noPaySalariedEmployee.equals(withPaySalariedEmployee));
    
    Assert.assertFalse("Volunteer and HourlyEmployee should not be equal",noPaySalariedEmployee.equals(new HourlyEmployee("test",0,0)));
    
    Assert.assertFalse("Volunteer and SalariedEmployee should not be equal",noPaySalariedEmployee.equals(new SalariedEmployee("test",0)));
  }
}
