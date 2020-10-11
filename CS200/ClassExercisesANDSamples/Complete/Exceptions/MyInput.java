import javax.swing.*;
import java.util.*;
import java.io.*;

/** 
 * Class to provide input routines
 * @author Imad Rahal
 * @version 05/26/2014
 */

public class MyInput {
  
  /** 
   * Method to return an integer data value.
   * @param file the name of file to read data from 
   */
  public void readIntFromFile(String file){
    try{ 
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      Scanner sc = new Scanner(new File(file));
      int number;
      while(sc.hasNext()) {
        number = sc.nextInt();
        System.out.println(number);
        numbers.add(number);
      }
      sc.close();
    }
    catch(InputMismatchException ime) {
      System.out.println ("Encountered an InputMismatchException: " + ime);
    }
    catch(FileNotFoundException fnfe){
      System.out.println ("Encountered a FileNotFoundException:" + fnfe);
      return;
    }
    catch(IOException ioe){
      System.out.println ("Encountered an IOException" + ioe);
      return;
    }
    catch(Exception ex){
      System.out.println("Encountered an Exception:" + ex);
    }
    finally{
      System.out.println("Wake up dude...you're in CSCI-200 now!");
    }
    System.out.println ("..... readIntFromFile method complete .....");
  }
  
  /** 
   * Method to return an integer data value.
   * @param file the name of file to read data from 
   * @throws FileNotFoundException if file name is wrong or file is not accessible; 
   * must be placed in a try/catch block
   */
  public void readIntFromFile2(String file) throws FileNotFoundException{
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    Scanner sc = new Scanner(new File(file));
    int number = 0;
    while(sc.hasNextInt()) {
      number = sc.nextInt();
      System.out.println(number);
      numbers.add(number);
    }
    sc.close();
    System.out.println ("..... readIntFromFile2 method complete .....");
  }
  
  public static void main(String [] args){
    MyInput mi = new MyInput();
    //1. FileNotFoundException
   // mi.readIntFromFile("dataw");
    
    //2. InputMismatchException
    //mi.readIntFromFile("data");
    
    //3.
    //mi.readIntFromFile2("dataw");
    
    //4.
    /* try{
     mi.readIntFromFile2("dataw");
     // mi.readIntFromFile2("data");
     }
     catch (FileNotFoundException fnfe){
     System.out.println(fnfe);
     }*/
    
  }
}
