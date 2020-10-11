
public class RecursiveMethods {
  
  public static int length(String str) {
    if (str == null || str.equals(""))
      return 0;
    else
      return 1 + length(str.substring(1));
  }
  
  
  public static void printChars(String str) {
    if (str == null || str.equals("")) {
      return;
    }
    else {
      System.out.println(str.charAt(0));
      printChars(str.substring(1));
    }
  }
  
  public static void printCharsReverse(String str) {
    if (str == null || str.equals("")) {
      return;
    }
    else {
      printCharsReverse(str.substring(1));
      System.out.println(str.charAt(0));
    }
  }
  
  public static int factorial(int n) {
    if (n == 1)
      return 1;
    else
      return n * factorial(n - 1);
  }
  
  public static int fibonacci(int n) {
    if (n < 2)
      return 1;
    else
      return fibonacci(n - 1) + fibonacci(n - 2);
  }
  
  
  public static int linearSearch(int[] items,int target, int pos) {
    if (pos == items.length)
    {
      return -1; 
    }
    else if (target == items[pos])
    {
      return pos;
    }
    else
    {
      return linearSearch(items, target, pos + 1); 
    }
    // for unsuccessful search ==> return -1; 
    // for successful search ==> return array location of match (i.e. position in array) 
  }
  
  public static int binarySearch(int[] items, int target, int first, int last) {
    if (first > last)
    {
      return -1;
    }
    else
    {
      int mid = (first + last) / 2;
      if (items[mid] == target)
      {
        return mid; 
      }
      else if (target < items[mid])
      {
        return binarySearch(items, target, first, mid - 1); 
      }
      else
      {
        return binarySearch(items, target, mid + 1, last); 
      }
      // Base case for unsuccessful search: (first > last) ==> return -1; 
      // Base case for successful search: target==items[middle] ==> return location of match
    }  
  }
}
