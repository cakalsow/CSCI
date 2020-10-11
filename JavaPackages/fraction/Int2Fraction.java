/*
 * Int2Fraction.java
 */

package fraction;

/** 
 * Fraction is an interface for objects that represent rational numbers
 * as fractions
 * 
 * @author Kayli and Channa
 * @version January 13, 2009
 */
public class Int2Fraction implements Fraction {
  private int numerator;
  private int denominator;
  /**
   * Add the specified addend to this Fraction and return the result
   * 
   * pre: result should be computable within the types used for the
   *      representation
   * post: this Fraction is unchanged
   * 
   * @param addend the Fraction to add to this Fraction
   * @return the sum of this Fraction and addend
   */
  public Int2Fraction() {
    numerator=0;
    denominator=1;
    
  }
  
  public Int2Fraction(int num) {
   numerator=num;
   denominator=1;
  }
  public Int2Fraction(int num, int den){
    if(den!=0){
      int i = gcd(num, den);
    numerator = num/i;
    denominator=den/i;
    if (denominator<0){
      denominator = -denominator;
      numerator = -numerator;
    }
    }
    else {
      throw new IllegalArgumentException("Denominator cannot be zero");
    }
  }
    private int gcd(int m, int n){
      if (m<0)
        return gcd(-m,n);
      else if (n<0)
        return gcd(m,-n);
      else if (m==0)
        return n;
      else 
        return gcd(n%m,m);
      }
    
      
    public Fraction addToThis(Fraction addend){
      return new Int2Fraction(numerator*addend.getDenominator() + denominator*addend.getNumerator(), denominator*addend.getDenominator());
    }
  
  /**
   * Subtract the specified subtrahend from this Fraction and return the result
   * 
   * pre: result should be computable within the types used for the
   *      representation
   * post: this Fraction is unchanged
   * 
   * @param subtrahend the Fraction to subtract from this Fraction
   * @return the difference between this Fraction (the minuend) and subtrahend
   */
    public Fraction subtractFromThis(Fraction subtrahend){
      return new Int2Fraction(numerator*subtrahend.getDenominator() - denominator*subtrahend.getNumerator(), denominator*subtrahend.getDenominator());
    }
  
  /**
   * Multiply this Fraction by the specified multiplier and return the result
   * 
   * pre: result should be computable within the types used for the
   *      representation
   * post: this Fraction is unchanged
   * 
   * @param multiplier the Fraction to multiply this Fraction by
   * @return the product of this Fraction (the multiplicand) and multiplier
   */
    public Fraction multiplyThisBy(Fraction multiplier){
  return new Int2Fraction(numerator*multiplier.getNumerator(), denominator*multiplier.getDenominator());
    }
  
  /**
   * Divide this Fraction by the specified divisor and return the result
   * 
   * pre: divisor is not a zero Fraction
   *      and result should be computable within the types used for the
   *      representation
   * post: this Fraction is unchanged
   * 
   * @param divisor the Fraction to divide this Fraction by
   * @return the quotient of this Fraction and divisor
   * @throws ArithmeticException if divisor is a zero Fraction
   */
    public Fraction divideThisBy(Fraction divisor){
      if (divisor.getNumerator()==0){
        throw new ArithmeticException("Cannot divide by zero");
      }
      else {
        return multiplyThisBy(new Int2Fraction(divisor.getDenominator(), divisor.getNumerator()));
    }
    }
  /**
   * 
   *???OR IS IT MULTIPLYTHISBY??
   * Compare this Fraction to another object to determine if they are equal
   *
   * post: this Fraction is unchanged
   * 
   * @param other the object to which to compare this Fraction
   * @return true if other is a Fraction equal to this Fraction; false otherwise
   */
  public boolean equals(Object other) {  
    try {
      Fraction otherFraction = (Fraction) other;
      return (otherFraction.getNumerator()*denominator == otherFraction.getDenominator()*numerator);
    } catch (ClassCastException cce) {
      return false;
    }
  }
  
  /**
   * Get the value of the numerator of this Fraction
   * 
   * post: this Fraction is unchanged
   * 
   * @return the Integer value of the numerator
   */
  public int getNumerator(){
  return numerator;
  }
  /**
   * Get the value of the denominator of this Fraction
   * 
   * post: this Fraction is unchanged
   * 
   * @return the Integer value of the denominator
   */
  public int getDenominator(){
  return denominator;
  }
}
