/*
 * File: Operator.java
 */
package expressions;
/**
 class that represents a Token of type Operator
 @author Imad Rahal
 @version April 23, 2014
 */
public abstract class Operator implements Token{
  
  /**
   returns the type of this Operator
   @return the type of this Operator
   */
  public Token.Type getType(){
    return Type.OPERATOR;
  }
  
  /**
   method for getting the precedence of this operator
   @return the precedence for this operator. Note that *, / and % operators have higher precedence than + and - operators
   */
  public abstract int getPrecedence();
  
  /**
   method for evaluating this operator on two operands
   @param op1 the first operand
   @param op2 the second operand
   @return op1 Operand op2
   */
  public abstract Operand evaluate(Operand o1, Operand o2);
  
  /**
   returns the Operator as a String
   @return the Operator as a String
   */
  public abstract String toString();
  
  
}
