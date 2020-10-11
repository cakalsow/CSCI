import org.junit.*;                // needed by JUnit4

import net.multitool.core.*;      // gain access to class being tested

/**
 * for JUnit testing of Account.java
 */

public class AccountTest{
  private Account acct1, acct2;
  
  // @Before annotation forces method to re-execute before each test method
  @Before
  public void init(){ 
    System.out.println("Setting up test objects...");
    acct1 = new Account();
    acct2 = new Account("Base", "Jon Bon", 15000);
  }
  
  // @After annotation forces method to re-execute after each test method
  @After
  public void destroy(){
    System.out.println("Tearing down test objects...");
    acct1 = null;
    acct2 = null;
  }
  
  /**
   * Test that default construtor is successful at setting class fields properly
   * Test that second construtor is successful at setting class fields properly
   * Test that second construtor fails for a negative total
   */ 
  @Test
  public void testDefaultConstructor(){
    Assert.assertTrue("Balance in acct1 is 0",acct1.getTotal()==0);
    //or using assertEquals  
    Assert.assertEquals("Balance in acct1 should be 0",0,acct1.getTotal());
    Assert.assertNull("Name of acct1 is should be null", acct1.getName());
    Assert.assertNull("Owner of acct1 is should be null",acct1.getOwner());
  }
  
  @Test
  public void testSecondConstructor(){
    Assert.assertTrue("Balance in acct2 should be 15000",acct2.getTotal()==15000);
    Assert.assertTrue("Name of acct2 is should be 'Base'",acct2.getName().equals("Base"));
    Assert.assertTrue("Owner of acct2 is should be 'Jon Bon'",acct2.getOwner().equals("Jon Bon"));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorFailsForNegativeTotal(){
    acct2 = new Account("Base", "Jon Bon", -150000);
  } 
  
  /**
   * COMPLETE ME *************************************************************************************************
   * Create a test method to test that method "credit" adds valid credit amounts to total balance properly
   * Create a test method to test that method "credit" fails for negative credit amounts
   */    
  @Test
  public void testCreditValidAmount(){
    
  } 
  
  @Test(expected = IllegalArgumentException.class)
  public void testCreditNegativeAmountFails(){
    
  }
  
  
  /**
   * COMPLETE ME *************************************************************************************************
   * Create a test method to test that method "setTotal" sets total balance to provided value if positive
   * Create a test method to test that method "setTotal" fails for negative provided values
   */ 
  
  @Test  
  public void testSetTotalValid(){
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testSetTotalNegativeFails(){
    ;
  }
  
  
  /**
   * COMPLETE ME *************************************************************************************************
   * Create a test method to test that method "debit" reduces total balance properly for valid withdrawls
   * Create a test method to test that method "debit" fails for negative withdrawls
   * Create a test method to test that method "debit" fails for withdrawls that exceed total balance
   */     
  
} // class AccountTest