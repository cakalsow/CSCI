/*
 * File: Remainder.java
 */

package expressions;

/**
 class that represents the Remainder or Modulus Operator
 @author Imad Rahal
 @version April 23, 2014
 */
public class Minus extends Operator{
  /**
   * a constant to store the precedece for this operator
   */
  private static final int subtractionPrecedence = 1;
  
  /**
   method for getting the precedence of this operator
   @return the precedence for this operator. Note that *, / and % operators have higher precedence than + and - operators
   */
  public int getPrecedence(){
    return subtractionPrecedence;
  }
  
  /**
   method for evaluating this operator on two operands
   @param op1 the first operand
   @param op2 the second operand
   @return the remainder of the integer subtraction of op1 by op2
   */
  public Operand evaluate(Operand op1, Operand op2){
    return new IntegerLiteral(op1.getValue() - op2.getValue());
  }
  
  /**
   method to return the sign for this operator
   @return "-"
   */
  public String toString(){
    return "-";
  }
  
}
