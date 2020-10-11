/*
 * File: TankTest.java
 */

import tank.*;

import org.junit.*;

/**
 * A JUnit test case class for the DoubleTank class.
 * 
 * Every method preceded with an @Test annotation will be called when running
 * the test with JUnit. Methods preceded with an @Before annotation are re-executed 
 * before each test method is run
 */
public class TankTest {
  
  private Tank emptyTank, // a tank initalized to be EMPTY
               fullTank, // a tank initalized to be FULL
               notFullTank;  // a tank initalized to be neither EMPTY nor  FULL
  
  @Before
  public void init() {
    emptyTank = new DoubleTank();       // uses default constructor
    notFullTank = new DoubleTank(250.0);
    notFullTank.add(50.0);
    fullTank = new DoubleTank();
    fullTank.add(DoubleTank.DEFAULT_CAPACITY);
  }
  
  @Test
  public void testDefaultConstructor() {
    Assert.assertTrue("emptyTank initially empty", emptyTank.isEmpty());
    Assert.assertTrue("emptyTank capacity is appropriate default", emptyTank.getCapacity()== 
                                                                   DoubleTank.DEFAULT_CAPACITY);
  }
  
  @Test
  public void testSecondConstructor(){
    Assert.assertTrue("notFullTank initially NOT empty", !notFullTank.isEmpty());
    Assert.assertTrue("notFullTank should have 50.0",notFullTank.getLevel()==50.0);
    Assert.assertTrue("notFullTank capacity is 250", notFullTank.getCapacity()== 250.0);  
  }
  @Test(expected = IllegalArgumentException.class)
  public void testContructorForNegativeCapacity(){
  notFullTank = new DoubleTank(-100.0);
  }
  
  // Put additional test methods here. Each method name must be preceded with an @Test annotation
  @Test
  public void testAddToEmptyTank() {
    emptyTank.add(50.0);
    Assert.assertTrue("Tank should have level of 50.0", emptyTank.getLevel()==50.0);
    Assert.assertFalse("emptyTank should have expected level", emptyTank.isEmpty());
    
  }
  
  @Test
  public void testAddToNonEmptyTank() {
    notFullTank.add(50.0);
    Assert.assertTrue("Tank should have level of 100.0", notFullTank.getLevel()==100.0);
    Assert.assertFalse("notFullTank should have expected level", notFullTank.isEmpty());
    
  }
 
  @Test
  public void testAddToCapacity() {
    notFullTank.add(200.0);
    Assert.assertTrue("notFullTank should be full", notFullTank.isFull());
    
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveNegativeAmountFromTank() {
   notFullTank.add(-100.0);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testAddFailsWhenExceedingCapacity() {
   notFullTank.add(250.0);
  }
  
  @Test
  public void testRemoveFromANonEmptyTank() {
    notFullTank.remove(25.0);
    Assert.assertTrue("Tank should have level of 25.0", notFullTank.getLevel()==25.0);
    Assert.assertFalse("notFullTank should have expected level", notFullTank.isEmpty());
    fullTank.remove(50.0);
    Assert.assertTrue("Tank should have a level of 200.0", fullTank.getLevel()==200.0);
    Assert.assertFalse("fullTank should not be full", fullTank.isFull());
    
  }
    
  @Test
  public void testRemoveToEmptyATank() {
    notFullTank.remove(50.0);
    Assert.assertTrue("Tank should have level of 0.0", notFullTank.getLevel()==0.0);
    Assert.assertTrue("notFullTank should have expected level", notFullTank.isEmpty());
    fullTank.remove(250.0);
    Assert.assertTrue("Tank should have a level of 0.0", fullTank.getLevel()==0.0);
    Assert.assertTrue("fullTank should be empty", fullTank.isEmpty());
  }
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveForNegativeNumbersFromTank() {
  notFullTank.remove(-100.0);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveFailsWhenExceedingLevel() {
    notFullTank.remove(100.0); 
  }
}
