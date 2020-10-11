
package expressions;
import java.util.*;
import zhstructures.*;
import ckeestructures.*;

//created by Emily and Channa

public class PostfixEvaluatorV2{
  
  
/*This method evaluates a postfix equation
 *@param a Queue<Token> parameter is recieved in this method
 * @return this method returns an int that represents the value of an evaluated postfix equation
 */
  
  
  
  public static int evaluate(ZHQueue<Token> postfixQueue)
  {
    if (postfixQueue.isEmpty())
    {
      throw new IllegalArgumentException("Empty postfix expression");
    }
    ZHStack<Operand> opStack = new CKEELinkedStack<Operand>();
    
    while (!postfixQueue.isEmpty())
    {
      Token nextTok = postfixQueue.dequeue();
      
      if (nextTok instanceof Operand)
      {
        opStack.push((Operand)nextTok);
      }
      else 
      {   
        if (opStack.isEmpty())
        {
          throw new IllegalArgumentException("Operator with no operands");
        }
         Operand rightOperand = opStack.pop();
        
        if (opStack.isEmpty())
        {
          throw new IllegalArgumentException("Operator with only one operand");
        }

        Operand leftOperand = opStack.pop();
        Operator  nextTokOp = (Operator) nextTok;;
        
        opStack.push(nextTokOp.evaluate(leftOperand, rightOperand)); 
      }
    }
    Operand resultOp = opStack.pop();
    int result  = resultOp.getValue();
    if (!opStack.isEmpty())
    {
      throw  new IllegalArgumentException("Too many operands");
    }
    return result;
  }
}

        
      