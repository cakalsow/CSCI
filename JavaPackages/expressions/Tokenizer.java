/*
 * File: Tokenizer.java
 */

package expressions;

import java.util.*;

/**
 * Class that encapsulates methods for extracting tokens from a String
 * that represents an arithmetic expression.
 * 
 * @author Kayli and Channa based on a template by J. Andrew Holey
 * @version October 6, 2020
 */
public class Tokenizer {
  
  /**
   * Returns a Token based on the supplied token string.
   * 
   * @param tokenStr the string the token is to be based on
   * @return a Token based on the supplied token string
   * @throws IllegalArgumentException if tokenStr doesn't represent a valid token
   */
  public static Token makeToken(String tokenStr) {
    Token result = null;
    //get first character in tokenStr
    char firstChar=tokenStr.charAt(0);
    //if first character is a digit, return I
    if(Character.isDigit(firstChar)){
      result = new IntegerLiteral(tokenStr);
    }else{//not a digit so it must be a single operator character
      //figure out which operator or throw exception if no matches are found
      switch (firstChar){
        case '+' : result = new Plus(); break;
        case '-' : result = new Minus(); break;
        case '*' : result = new Times(); break;
        case '/' : result = new Divide(); break;
        case '%' : result = new Remainder(); break;
        case '(' : result = new LeftParenthesis(); break;
        case ')' : result = new RightParenthesis(); break;
        
      }
 
      if (result == null)
      {
        throw new IllegalArgumentException("No token."); 
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
  public static Queue<Token> parseString(String tokensStr) {
    //start with an empty queue of tokens 
    Queue<Token> result=new ArrayDeque<Token>();
    int i=0;
    while (i<tokensStr.length()){
      int j=i;
    //loop over all characaters in string tokensStr
      //a quick way to check if character at location i in 
      // tokensStr is an operator or a parenthesis 
      if(Character.isDigit(tokensStr.charAt(i))){
        while(i< tokensStr.length() && Character.isDigit(tokensStr.charAt(i))){
          i++;
        }
        //call makeToken on that character
        // add the resulting token to the queue
        Token tkn = makeToken(tokensStr.substring(j,i));
        result.add(tkn);
      }
      //check if character at location i in tokensStr is a digit 
      else if(tokensStr.charAt(i) == ' '){
        i++;
      }
      else {
        i++;
        Token tkn = makeToken(tokensStr.substring(j,i));
        result.add(tkn);
      }
    }
    return result;
  }
}
