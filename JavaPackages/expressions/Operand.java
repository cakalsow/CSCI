package expressions;
//takes methods from token interface
public abstract class Operand implements Token
{
  //geets value from abstract class
 public abstract int getValue();
 //gets the type from token
 public Token.Type getType()
 {
  return Type.OPERAND; 
 }
}