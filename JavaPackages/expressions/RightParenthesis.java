package expressions;
//gets type left parenthesis from interface token
public class RightParenthesis implements Token
{
  //gets type from token
  public Token.Type getType()
  {
   return Type.RIGHT_PARENTHESIS;
  }
  //defines string 
  public String toString()
  {
   return (")"); 
  }
}