/**
 File InfixToPostfix.java
 */
package expressions;
import java.util.*;
import zhstructures.*;
import ckeestructures.*;
/**
 class that converts infix expressions to postfix expressions
 * @author <Emily and Channa>, based on a template by J. Andrew Holey
 * @version <October 9th 2020>
 */
public class InfixToPostfixV2{
  
  /**
   a method for converting infix to postfix
   @param Queue<Token> the infix expression
   @return Queue<Token> the postfix expression
   @throws IllegalArgumentException if infixQueue is empty
   */
  public static ZHQueue<Token> convert(ZHQueue<Token> infixQueue){
    //check that infixQueue isn't empty
    if (infixQueue.isEmpty()){
      throw new IllegalArgumentException("Empty infix expression");
    }
    
    //set postfixQueue <-- empty Queue<Token> 
    ZHQueue<Token> postfixQueue = new CKEELinkedQueue<Token>();
    
    //set opStack <-- empty Stack<Token> 
    ZHStack<Token> opStack = new CKEELinkedStack<Token>();
    
    //loop over infix queue
    while(!(infixQueue.isEmpty())){
      //dequeue nextTok from infixQueue
      Token next = infixQueue.dequeue();
      //check if nextTok is an operand
      if(next instanceof Operand){
        postfixQueue.enqueue(next);
      }
      else if (next instanceof LeftParenthesis)
      {
        opStack.push(next);
      }
      else if(next instanceof RightParenthesis)
      {
        processRightParenthesis(opStack, postfixQueue);
      }
      else
      {
        
        processOperator(opStack, postfixQueue, (Operator)next);
      }

    }
    //loop over opStack
    while(!(opStack.isEmpty())){
      //pop nextOp from opStack 
      Token nextOp = opStack.pop();
      if (nextOp instanceof LeftParenthesis)
      {
        throw new IllegalArgumentException("Unmatched left parenthesis");
      }
      postfixQueue.enqueue(nextOp);
    }
    return postfixQueue;
  }
  
  
  
  /**
   method for processing right parenthesis in an infix expression
   @param STack<Token> a stack for the operators
   @param Queue<Token> the postfix expression
   */
  private static void processRightParenthesis(ZHStack<Token> opStack, ZHQueue<Token> postfixQueue){
    //while opStack is not empty and top of opStack is not a left parenthesis 
    while(!opStack.isEmpty() && 
          !(opStack.peek() instanceof LeftParenthesis) )
    {  
      postfixQueue.enqueue(opStack.pop());
    }
    if (opStack.isEmpty())
    {
      throw new IllegalArgumentException("Unmatched right parenthesis");
    }
    opStack.pop();//not sure if this is right
  }
  
  
  
  /**
   method for processing operators in an infix expression
   @param Stack<Token> the operator Stack
   @param Queue<Token> the postfix expression
   @param Operator the operator being evaluated
   */
  private static void processOperator(ZHStack<Token> opStack, ZHQueue<Token> postfixQueue, Operator op){
    //create a Token variable to store Token at top of opStack
    Token topTok=null;
    //set topTok to first Token on opStack if it isn't empty
    if(!opStack.isEmpty()){
      topTok = opStack.peek();//set topTok <-- top element of opStack [ peek without popping ]
    }
    
    //while opStack is not empty and topTok is not a left parenthesis 
    // and precedence of parameter op is <= precedence of topTok
    while(!opStack.isEmpty() && 
          !(topTok instanceof LeftParenthesis)  && 
          op.getPrecedence()<= ((Operator)topTok).getPrecedence()){
      postfixQueue.enqueue(opStack.pop());
      if (!opStack.isEmpty())
      {
        topTok = opStack.peek();
      }
    }
opStack.push(op);
  }
  
}

