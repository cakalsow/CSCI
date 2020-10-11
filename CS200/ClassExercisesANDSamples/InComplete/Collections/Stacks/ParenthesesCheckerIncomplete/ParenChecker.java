import java.util.Stack;
import java.util.EmptyStackException;
import javax.swing.JOptionPane;

/** Class to check for balanced parentheses.
  *   @author Koffman & Wolfgang
  * */

public class ParenChecker {
  
  // Constants
  /** 
   * Set of opening parenthesis characters. 
   */
  private static final String OPEN = "([{";
  
  /** 
   * Set of closing parenthesis characters, matches OPEN.
   */
  private static final String CLOSE = ")]}";
  
  /** 
   * Method to determine whether a character is one of the
   * opening parentheses.
   * @param ch Character to be tested
   * @return true if ch is one of the opening parentheses
   */
  private static boolean isOpen(char ch) {
    return OPEN.indexOf(ch) > -1;
  }
  
  /** 
   * Method to determine whether a character is one of the
   * closing parentheses.
   * @param ch Character to be tested
   * @return true if ch is one of the closing parentheses
   */
  private static boolean isClose(char ch) {
    return CLOSE.indexOf(ch) > -1;
  }
  
  /** 
   * Test the input string to see that it contains balanced
   * parentheses. This method tests an input string to see
   * that each type of parenthesis is balanced. '(' is matched
   * with ')', '[' is matched with ']', and '{' is matched with '}'.
   * 
   * @param expression A String containing the expression to
   * be examined
   @return true if all the parentheses match
   */
  public static boolean isBalanced(String expression) {
    // Create an empty stack.
    Stack < Character > s = new Stack < Character > ();
    boolean balanced = true;
    int index = 0;
    /*
     * COMPLETE ME: ********************************************************************************************************************
     * loop over the characters of the string and do the following depending on the character encountered
     1- for an "opening" paranthesis: push onto the stack
     2- for a "closing" paranthesis: 
         - if stack isn't empty, pop it and check of parantheses match; set variable balanced accordingly
         - otherwise, we have a "closing" paranthesis without a corresponding "opening" one so expression isn't balanced
     3- after loop finishes, value of balanced is returned unless stack is not empty .... what does that mean? think about it.
     */
         
    while (balanced && index < expression.length()) {
      //Your code goes here ************************************************************************************************************
      index++;
    }
    
    return false; //Update this line as well  ******************************************************************************************
  }
  
  
  /** 
   * main method. Ask the user for a string and
   * call the ParenChecker to see whether the parentheses
   * are balanced.
   @param args Not used
   */
  public static void main(String args[]) { 
    String expression = JOptionPane.showInputDialog("Enter an expression containing parentheses");
    /* try out the following:
     * 1- (a+b*(c/(d-e)))+(d/e) => true
     * 2- (a+b*(c/(d-e)))+{d/e) => false
     * 3- (a+b*{c/[d-e]} )+(d/e) => true
     * 4- (a+b*{c/[d-e]} ){+(d/e) => false
     * 5- (a+b*{c/[d-e]} )+(d/e)] => false*/
    if (ParenChecker.isBalanced(expression)) {
      System.out.println(expression+ " is balanced");
    }
    else {
      System.out.println(expression + " is not balanced");
    }
  }
}
