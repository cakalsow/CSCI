import org.junit.*;
import fraction.*;
/**
 * A JUnit test case class for the IntFraction class.
 * 
 */
public class FractionTest2 {
  
  private Fraction frac1, frac2, frac3, frac4;
  
  @Before
  public void init() {
    //frac1 and frac2 are created using constructor 3
    frac1 = new Int2Fraction(5,7);
    frac2 = new Int2Fraction(1,2);
    //frac3 is created using constructor 1
    frac3 = new Int2Fraction();
    //frac4 is created using constructor 2
    frac4 = new Int2Fraction(5);
  }
  
  /**
   * Complete the test methods below to test the three constructors in class IncFraction. We need to make 
   * sure that the constructors work properly and do not take a 0 parameter for the demonimator.
   * 1. Test each of the frac instance variables has the correct numerator and denominator  
   * 2. Check that contructor 3 fails to create a fraction with a zero denominator
   */
  
  @Test
  public void testDefaultConstructor(){
    Assert.assertTrue("frac3 numerator is 0", frac3.getNumerator()==0);
    Assert.assertTrue("frac3 denominator is 1", frac3.getDenominator()==1);
  }
  
  @Test
  public void testSecondConstructor(){
    Assert.assertTrue("frac4 numerator is 5", frac4.getNumerator()==5);
    Assert.assertTrue("frac4 denominator is 1", frac4.getDenominator()==1);
  }
  
  @Test
  public void testThirdConstructor(){
    Assert.assertTrue("frac1 numerator is 5", frac1.getNumerator()==5);
    Assert.assertTrue("frac1 numerator is 7", frac1.getDenominator()==7);
    Assert.assertTrue("frac2 numerator is 1", frac2.getNumerator()==1);
    Assert.assertTrue("frac2 numerator is 2", frac2.getDenominator()==2);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorFailsForZeroDenominator(){
  new Int2Fraction(2,0);
  }
  
  /**
   * Complete the test method below to test that method addToThis returns a correct fraction result and that the 
   * operand fractions (frac1 and frac2) do not change as a result of this operation
   */  
  @Test
  public void testAddToThis(){
    Fraction test = (Int2Fraction) frac1.addToThis(frac2); 
    Assert.assertTrue("result is numerator 15", test.getNumerator()==17);
    Assert.assertTrue("result is denominator 18", test.getDenominator()==14);
    Assert.assertTrue("frac1 is numerator 5", frac1.getNumerator()==5);
    Assert.assertTrue("frac1 is denominator 7", frac1.getDenominator()==7);
    Assert.assertTrue("frac2 is numerator 1", frac2.getNumerator()==1);
    Assert.assertTrue("frac2 is denominator 2", frac2.getDenominator()==2);
  }
  
  /**
   * Add the following test methods (create a separate, clearly-named test method for each case)
   * 
   * 1- test that method subtractFromThis returns a correct fraction result and that 
   * operand fractions do not change as a result of this operation
  */
  @Test
  public void testSubtractFromThis(){
    Fraction test = (Int2Fraction) frac1.subtractFromThis(frac2); 
    Assert.assertTrue("result is numerator 3", test.getNumerator()==3);
    Assert.assertTrue("result is denominator 14", test.getDenominator()==14);
    Assert.assertTrue("frac1 is numerator 5", frac1.getNumerator()==5);
    Assert.assertTrue("frac1 is denominator 7", frac1.getDenominator()==7);
    Assert.assertTrue("frac2 is numerator 1", frac2.getNumerator()==1);
    Assert.assertTrue("frac2 is denominator 2", frac2.getDenominator()==2);
  }
  /**
   * 
   * 2- test that method multiplyThisBy returns a correct fraction result and that 
   * operand fractions do not change as a result of this operation
   */
  @Test
  public void testMultiplyThisBy(){
    Fraction test = (Int2Fraction) frac1.multiplyThisBy(frac2); 
    Assert.assertTrue("result is numerator 5", test.getNumerator()==5);
    Assert.assertTrue("result is denominator 14", test.getDenominator()==14);
    Assert.assertTrue("frac1 is numerator 5", frac1.getNumerator()==5);
    Assert.assertTrue("frac1 is denominator 7", frac1.getDenominator()==7);
    Assert.assertTrue("frac2 is numerator 1", frac2.getNumerator()==1);
    Assert.assertTrue("frac2 is denominator 2", frac2.getDenominator()==2);
  }
  /**
   * 3- test that method divideThisBy returns a correct fraction result and that 
   * operand fractions do not change as a result of this operation
   */
  @Test
  public void testDivideThisBy(){
    Fraction test = (Int2Fraction) frac1.divideThisBy(frac2); 
    Assert.assertTrue("result is numerator 10", test.getNumerator()==10);
    Assert.assertTrue("result is denominator 7", test.getDenominator()==7);
    Assert.assertTrue("frac1 is numerator 5", frac1.getNumerator()==5);
    Assert.assertTrue("frac1 is denominator 7", frac1.getDenominator()==7);
    Assert.assertTrue("frac2 is numerator 1", frac2.getNumerator()==1);
    Assert.assertTrue("frac2 is denominator 2", frac2.getDenominator()==2);
  }
  /**
   * 4- test that method divideThisBy fails if provided a zero fraction as a parameter 
   */
 @Test(expected = ArithmeticException.class)
  public void testDivideThisByFailsForWhenDividingByZero(){
   frac1.divideThisBy(new Int2Fraction());
 }
  /**
   * 5- test that two fractions with the same numerators and denominators are equal 
   */
  @Test
  public void testEqualsFractionWithSameNumAndDen(){
    Fraction test = new Int2Fraction(5,7);
   Assert.assertTrue("These are equal", frac1.equals(test));
  }
  /**
   * 6- test that two fractions may still be equal even with the different numerators and denominators 
   *     - e.g. 1: 5/7 and 10/14 
   *     - e.g. 2: 1/2 and -5/-10
   */
  @Test
  public void testEqualsForEqualFractionsWithDiffNumAndDen(){
    Fraction test2 = new Int2Fraction(10,14);
    Assert.assertTrue("These are equal", frac1.equals(test2));
    Fraction test3 = new Int2Fraction(-5, -10);
    Assert.assertTrue("These are equal", frac2.equals(test3));
  }
  /**
   * 7- test that two fractions may be unequal (e.g. 5/7 and -5/-10)
   */
 @Test
  public void testEqualsForNonEqualFractions(){
    Assert.assertFalse("These are not equal", frac1.equals(frac2));
    Fraction test3 = new Int2Fraction(-5, -10);
    Assert.assertFalse("These are not equal", frac1.equals(test3));
}
}