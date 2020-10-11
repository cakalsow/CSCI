package expressions;
import java.util.*;
//evaluating postfix entered using a queue
public class PostfixEvaluator
{
  public static int evaluate(Queue<Token> postfixQueue)
  {
    //tests whether postfix is empty and throws appropriate error
    if (postfixQueue.isEmpty())
    {
      throw new IllegalArgumentException("Empty postfix expression."); 
    }
    //creates new empty stack
    Stack<Operand> opStack = new Stack <Operand>();
    //if queue is not empty, removes next element in queue
    while (!postfixQueue.isEmpty())
    {
      Token nextTok = postfixQueue.remove();
      //pushes next element if it is an Operand
      if (nextTok instanceof Operand)
      {
        opStack.push((Operand)nextTok); 
      }
      //tests whether opStack is empty and throws appropriate error
      else
      {
        if (opStack.empty())
        {
          throw new IllegalArgumentException("Operator with no operands.");
        }
        
        Operand rightOperand = opStack.pop();
        //tests whether opStack is empty and throws appropriate error
        if (opStack.empty())
        {
          throw new IllegalArgumentException("Operator with only one operand."); 
        }
        //evaluates left and right operands
        Operand leftOperand = opStack.pop();
        nextTok = (((Operator)nextTok).evaluate(leftOperand, rightOperand));
        opStack.push((Operand)nextTok);
      }
    }
    //tests whether opStack is empty and throws appropriate error
    Operand result = opStack.pop();
    if (!opStack.empty())
    {
      throw new IllegalArgumentException("Too many operands."); 
    }
    return result.getValue();
  }
}