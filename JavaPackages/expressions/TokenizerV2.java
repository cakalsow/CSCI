/*
 * File: Tokenizer.java
 */
//created by Emily and Channa
package expressions;
import zhstructures.*;
import java.util.*;
import ckeestructures.*;

/**
 * Class that encapsulates methods for extracting tokens from a String
 * that represents an arithmetic expression.
 * 
 * @author <your name here>, based on a template by J. Andrew Holey
 * @version <put todays date>
 */
public class TokenizerV2 {
  
  /**
   * Returns a Token based on the supplied token string.
   * 
   * @param tokenStr the string the token is to be based on
   * @return a Token based on the supplied token string
   * @throws IllegalArgumentException if tokenStr doesn't represent a valid token
   */
  public static Token makeToken(String tokenStr) throws IllegalArgumentException{
     //System.out.println(tokenStr);
    Token result;
    //get first character in tokenStr
    char firstChar=tokenStr.charAt(0);
    //if first character is a digit, return I
    
    if(Character.isDigit(firstChar)){
     
      result = new IntegerLiteral(tokenStr);
    }
    
    else{
    //not a digit so it must be a single operator character
      //figure out which operator or throw exception if no matches are found
      switch (firstChar){
        case '+' : result = new Plus();break;
        
        case '-' : result = new Minus(); break;
        
        case '/' : result = new Divide(); break;
        
        case '*' : result = new Times(); break;
        
        case '(' : result = new LeftParenthesis(); break;
        
        case ')' : result = new RightParenthesis(); break;
        
        case '%' : result = new Remainder(); break;
        
        default: throw new IllegalArgumentException("Invalid Operator");
      }
    }
    
    return result;
  }
  
  /**
   * Parses the supplied token string and returns a queue of tokens.
   * 
   * @param tokensStr the string the tokens are to be parsed from
   * @return a queue of tokens in the same order they appeared in the original string
   * @throws IllegalArgumentException if tokensStr contains unparseable subsequences
   */
  public static ZHQueue<Token> parseString(String tokensStr) {
    //start with an empty queue of tokens 
    ZHQueue<Token> result=new CKEELinkedQueue<Token>();
    //loop over all characaters in string tokensStr
    for(int i = 0; i < tokensStr.length(); i++){
      //a quick way to check if character at location i in 
      // tokensStr is an operator or a parenthesis 
      if(("+-*%/)(").indexOf(tokensStr.charAt(i))!=-1){
        //call makeToken on that character
        // add the resulting token to the queue
        result.enqueue(makeToken(tokensStr.substring(i)));
        
      }
      //check if character at location i in tokensStr is a digit 
      else if(Character.isDigit(tokensStr.charAt(i)))  {
         int j = i;
         
         try{
           while(Character.isDigit(tokensStr.charAt(j))) {
     
          j++; 
           }
         }
         catch (StringIndexOutOfBoundsException e){
         
               }
        result.enqueue(new IntegerLiteral(Integer.parseInt(tokensStr.substring(i,j))));   
        i = j-1; 
      }
      else if (tokensStr.charAt(i) == ' ' ) {
     
      }
      else {
        throw new IllegalArgumentException("Invalid character within token");
      }
    }
    return result;
  }
}
