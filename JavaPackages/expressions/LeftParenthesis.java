package expressions;
//gets type left parenthesis from interface token
public class LeftParenthesis implements Token
{
  //method from token to get type
  public Token.Type getType()
  {
   return Type.LEFT_PARENTHESIS;
  }
  //defining string type
  public String toString()
  {
   return ("("); 
  }
}