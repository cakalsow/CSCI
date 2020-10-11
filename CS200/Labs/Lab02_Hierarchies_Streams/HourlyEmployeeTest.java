/**
 * HourlyEmployeeTest.java
 */

import worker.*;
import org.junit.*;

public class HourlyEmployeeTest {
  private HourlyEmployee noHoursHourlyEmployee, withHoursHourlyEmployee, withPayHourlyEmployee;
  
  @Before
  public void init(){
    // creates HourlyEmployee workers with name
    noHoursHourlyEmployee = new HourlyEmployee("noHoursEmployee");
    withHoursHourlyEmployee = new HourlyEmployee("withHoursHourlyEmployee",10);
    withPayHourlyEmployee = new HourlyEmployee("withPayHourlyEmployee", 10, 10.0);
  }
  
  /**
   * test that the constructor in class HourlyEmployee sets the name and hours fields to the expected 
   * initial values and that the toString method returns the String "HourlyEmployee" 
   */
  @Test
  public void testHourlyEmployeeConstructor(){
    Assert.assertTrue("noHoursHourlyEmployee should have given name",noHoursHourlyEmployee.getName().equals("noHoursEmployee"));
    Assert.assertTrue("Hours in noHoursHourlyEmployee should be 0 initially", noHoursHourlyEmployee.getHours() == 0);
    Assert.assertTrue("Pay for withPayHourlyEmployee should be 10.0 initially", withPayHourlyEmployee.getHourlyPay() == 10.0);
    Assert.assertTrue("Pay for withPayHourlyEmployee should be 10.0 initially", withPayHourlyEmployee.getMonthlyPay() == 10.0);
    Assert.assertTrue("toString should return 'Hourly Employee'",noHoursHourlyEmployee.toString().equals("Hourly Employee"));
    
    Assert.assertTrue("withHoursHourlyEmployee should have given name",withHoursHourlyEmployee.getName().equals("withHoursHourlyEmployee"));
    Assert.assertTrue("Hours in withHoursHourlyEmployee should be 10 initially", withHoursHourlyEmployee.getHours() == 10);
    Assert.assertTrue("toString should return 'HourlyEmployee'",withHoursHourlyEmployee.toString().equals("Hourly Employee"));    
  }  
  
  
  /**
   * test that method addHours in HourlyEmployee adds non-negative hours properly
   */ 
  @Test
  public void testAddHoursValidParameter(){
    noHoursHourlyEmployee.addHours(5);
    Assert.assertTrue("Hours should add positive numbers correctly",noHoursHourlyEmployee.getHours()==5);
    withHoursHourlyEmployee.addHours(6);
    Assert.assertTrue("Hours should add positive numbers correctly",withHoursHourlyEmployee.getHours()==16);   
  }
  
  
  /**
   * test that method addHours in HourlyEmployee fails as expected for negative hours
   */
  @Test(expected=IllegalArgumentException.class)
  public void testAddHoursFailsForNegativeParameter(){
    noHoursHourlyEmployee.addHours(-5);
  }
  
  
  /**
   * test that method resetHours in HourlyEmployee works properly 
   */   
  @Test
  public void testResetHours(){
    noHoursHourlyEmployee.resetHours();
    Assert.assertTrue("Hours should be reset to 0",noHoursHourlyEmployee.getHours()==0);

    withHoursHourlyEmployee.resetHours();
    Assert.assertTrue("Hours should be reset to 0",withHoursHourlyEmployee.getHours()==0);     
  }
  
  /**
   * test that method equals returns true for different Workers with the same names  
   */  
  @Test
  public void testEqualsDifferentWorkersSameNames(){
    noHoursHourlyEmployee = new HourlyEmployee("test");
    withHoursHourlyEmployee = new HourlyEmployee("test",10);
    Assert.assertTrue("HourlyEmployee should be equal",noHoursHourlyEmployee.equals(withHoursHourlyEmployee));
    
    Assert.assertTrue("HourlyEmployee and HourlyEmployee should be equal",noHoursHourlyEmployee.equals(new HourlyEmployee("test",0,0)));
    
    Assert.assertTrue("HourlyEmployee and SalariedEmployee should be equal",noHoursHourlyEmployee.equals(new SalariedEmployee("test",0)));
  }
  
  /**
   * test that method equals returns false for Workers with different names  
   */  
  @Test
  public void testEqualsDifferentWorkersDifferentNames(){
    Assert.assertFalse("HourlyEmployees should not be equal",noHoursHourlyEmployee.equals(withHoursHourlyEmployee));
    
    Assert.assertFalse("HourlyEmployee and HourlyEmployee should not be equal",noHoursHourlyEmployee.equals(new HourlyEmployee("test",0,0)));
    
    Assert.assertFalse("HourlyEmployee and SalariedEmployee should not be equal",noHoursHourlyEmployee.equals(new SalariedEmployee("test",0)));
  }
}
