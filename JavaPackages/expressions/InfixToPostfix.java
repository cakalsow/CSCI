/**
 File InfixToPostfix.java
 */
package expressions;
import java.util.*;
/**
 class that converts infix expressions to postfix expressions
 * @author <your name here>, based on a template by J. Andrew Holey
 * @version <put todays date>
 */
public class InfixToPostfix{
  
  /**
   a method for converting infix to postfix
   @param Queue<Token> the infix expression
   @return Queue<Token> the postfix expression
   @throws IllegalArgumentException if infixQueue is empty
   */
  public static Queue<Token> convert(Queue<Token> infixQueue){
    Token nextTok = null;
    Token nextOp = null;
    //check that infixQueue isn't empty
    if (infixQueue.isEmpty()){
      throw new IllegalArgumentException("Empty infix expression");
    }
    
    //set postfixQueue <-- empty Queue<Token> 
    Queue<Token> postfixQueue = new ArrayDeque<Token>();
    
    //set opStack <-- empty Stack<Token> 
    Stack<Token> opStack = new Stack<Token>();
    
    //loop over infix queue
    while(!(infixQueue.isEmpty())){
      //dequeue nextTok from infixQueue
      nextTok = infixQueue.peek();
      //check if nextTok is an operand
      if(nextTok instanceof Operand){
        postfixQueue.add(infixQueue.remove());
      }
      else if (nextTok instanceof LeftParenthesis)
      {
        opStack.push(infixQueue.remove());
      }
      else if (nextTok instanceof RightParenthesis)
      {
        infixQueue.remove();
        processRightParenthesis(opStack,postfixQueue);
      }
       else
       {
         Operator op = (Operator) infixQueue.remove();
         processOperator(opStack,postfixQueue, op);
       }
        
    }
    //loop over opStack
    while(!(opStack.isEmpty())){
      //pop nextOp from opStack 
      nextOp = opStack.pop();
      if (nextOp instanceof LeftParenthesis)
      {
        throw new IllegalArgumentException("Unmatched Left Parenthesis");
      }
      postfixQueue.add(nextOp);
    }
    return postfixQueue;
  }
  
  
  
  /**
   method for processing right parenthesis in an infix expression
   @param STack<Token> a stack for the operators
   @param Queue<Token> the postfix expression
   */
  private static void processRightParenthesis(Stack<Token> opStack, Queue<Token> postfixQueue){
    //while opStack is not empty and top of opStack is not a left parenthesis 
    while(!opStack.isEmpty() && !(opStack.peek() instanceof LeftParenthesis) )
    {
     postfixQueue.add(opStack.pop());
    }
    if (opStack.empty())
    {
      throw new IllegalArgumentException("Unmatched Right Parenthesis");
    }
      opStack.pop();
  }
  
  
  
  /**
   method for processing operators in an infix expression
   @param Stack<Token> the operator Stack
   @param Queue<Token> the postfix expression
   @param Operator the operator being evaluated
   */
  private static void processOperator(Stack<Token> opStack, Queue<Token> postfixQueue, Operator op){
    //create a Token variable to store Token at top of opStack
    Token topTok=null;
    //set topTok to first Token on opStack if it isn't empty
    if(!opStack.isEmpty()){
      topTok = opStack.peek();//set topTok <-- top element of opStack [ peek without popping ]
    }
    
    //while opStack is not empty and topTok is not a left parenthesis 
    // and precedence of parameter op is <= precedence of topTok
    while(!opStack.isEmpty() &&  !(topTok instanceof LeftParenthesis)  && 
          op.getPrecedence()<= ((Operator)topTok).getPrecedence()){
    postfixQueue.add(opStack.pop());
    if (!opStack.empty())
    {
      topTok = opStack.peek();
    }
    }
    opStack.push(op);
      
    }
}

