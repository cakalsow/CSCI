/* File: CityNamesStream.java */

import java.util.*;
import java.io.*;

/**
 * This class contains three  methods: input2TextFile,
 * textFile2ObjectFile, and objectFile2output that move 
 * text from one source or file to another. They function 
 * sequentially, like a pipeline in which each method 
 * accomplishes a specific chunch of the functionality.
 * 
 * @author Kayli and Channa, based on a template by I. Rahal
 * @version Oct 5, 2020
 */

public class CityNamesStream {
  
  /**
   * Reads city names, one per line, from standard input and 
   * writes them to the text file specified as parameter.
   * 
   * Stops on a line consisting of the period character, "."
   * without copying the period.
   *  
   * @param textFileName the name of the file to write to
   */
  public void input2TextFile(String textFileName) {
    Scanner systemInScan = new Scanner(System.in);
    String cityName = "";
    boolean output = false;
    try{
      PrintWriter pw = new PrintWriter(new File(textFileName));
      while (output != true)
      {
        if (!cityName.equals("."))
        {
          System.out.println("Enter the city name or type '.' when finished : ");
          cityName = systemInScan.nextLine();
          
          if (!cityName.equals("."))
          {
            pw.println(cityName);
            
          }
        }
        else
        {
          output = true;
          pw.close();
        }
      }
      
    }catch(IOException ioe){
      return;
    }
  }
  
  /**
   * Reads city names from an input text file,one per line, stores 
   * them in a List object and writes the object to an object file
   * 
   * @param textFileName the name of the text file to read from
   * @param objectFileName the name of the object file to write to
   */
  public void textFile2ObjectFile(String textFileName, String objectFileName) {
    try{  
 
      ObjectOutputStream object = new ObjectOutputStream( new FileOutputStream(objectFileName));
      ArrayList <String> list = new ArrayList<String>();
      Scanner textFileScan = new Scanner(new File(textFileName));
      while (textFileScan.hasNextLine())
      {
        String str = (textFileScan.nextLine());
        System.out.println(str);
        list.add(str);
      }
      object.writeObject(list);
      textFileScan.close();
      object.close();
      
      return;
      
    }catch(IOException ioe){
      return;
    }      
  }
  
  

  /**
   * Reads file, puts contents in an array, and 
   * prints them to the console.
   * 
   *  
   * @param textFileName the name of the file to read
   */
  public void objectFile2Output(String objectFileName) {
    try{
      ObjectInputStream input = new ObjectInputStream(new FileInputStream(objectFileName));
      List<String> read = (List<String>) input.readObject();
      
      for (String s : read)
      {
        System.out.println(s);
        input.close();
      }
    }
    catch(IOException ioe)
    {
      System.err.println(ioe);
    }
    catch(ClassNotFoundException cce)
    {
      System.err.println(cce); 
    }
  }
}

