package expressions;
//gets methods from the operand and token interface
public class IntegerLiteral extends Operand
{
  public int literal;
  //first constructor throws the illegalArgumentExceotion
  public IntegerLiteral(String number)
  {
    try
    {
      this.literal = Integer.parseInt(number);
    }
    catch(NumberFormatException e)
    {
      throw new IllegalArgumentException(e.getMessage());
    }
  }
  //second Constructor gets the values for the extended classes
  public IntegerLiteral(Integer number)
  {
    this.literal = number; 
  }
  
  public int getValue()
  {
    return this.literal;
  }
  // defines the string from token and inputs the values and returns them to string
  public String toString()
  {
    String string = new Integer(this.getValue()).toString();
    return string; 
  }
}