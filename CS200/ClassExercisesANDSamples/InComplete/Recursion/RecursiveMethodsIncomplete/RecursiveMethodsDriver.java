/* A class for recursive methods
   @author Koffman and Wolfgang
 */

public class RecursiveMethodsDriver {
  public static void main(String[] args){
    //String examples
    System.out.println("length of tinkerbell : " + RecursiveMethods.length("tinkerbell"));
    System.out.println("characters in tinkerbell : ");
    RecursiveMethods.printChars("tinkerbell");    
    System.out.println("reverse of tinkerbell : ");
    RecursiveMethods.printCharsReverse("tinkerbell");
    //math examples
    System.out.println("factorial of 7 : " + RecursiveMethods.factorial(7));
    System.out.println("fibonacci of 3 : " + RecursiveMethods.fibonacci(3));  
    
    //searching examples
    int[] arr = {0,10,20,30,40,50,60,70};
    System.out.println("Linear search: 60 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.linearSearch(arr,60,0));
    System.out.println("Linear search: 80 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.linearSearch(arr,80,0));

    System.out.println("Binary search: 60 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.binarySearch(arr,60,0,arr.length-1));
    System.out.println("Binary search: 80 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.binarySearch(arr,80,0,arr.length-1));
    
    

  }
}
