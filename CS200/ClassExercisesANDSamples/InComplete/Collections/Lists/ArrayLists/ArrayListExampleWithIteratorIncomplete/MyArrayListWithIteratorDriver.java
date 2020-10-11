import java.util.*;
import mydatastructures.*;

public class MyArrayListWithIteratorDriver{
  
  
  
  public static void main(String[] args){
    MyList<String> myList = new MyArrayList<String>();

    System.out.println("Initially size is:" + myList.size());
    System.out.println("*******************************************************");
    myList.add("160");
    myList.add("200");
    myList.add("230");
    myList.add("310");
    System.out.println("Size after adding is :" + myList.size());
    System.out.println("Elements after adding....");
    for(int i = 0; i<myList.size();i++){
      System.out.println("Element @ location " + i + " is :"+myList.get(i));
    }
    System.out.println("*******************************************************");
    
    for(int i = 0; i<myList.size();i++){
      myList.set(i,"CSCI-"+myList.get(i));
    }  
    System.out.println("Size after updating is :" + myList.size());
    System.out.println("Elements after updating....");    
    for(int i = 0; i<myList.size();i++){
      System.out.println("Element @ location " + i + " is :"+myList.get(i));
    }
    System.out.println("*******************************************************");
    
    myList.remove(1);
    System.out.println("Size after removing is :" + myList.size());
    System.out.println("Elements after removing....");    
    for(int i = 0; i<myList.size();i++){
      System.out.println("Element @ location " + i + " is :"+myList.get(i));
    }    
    myList.add(1,"CSCI-200");
    System.out.println("*******************************************************");
    System.out.println("Using the enhanced for loop....");    
    for(String s: myList){
      System.out.println(s);
    }
    
    System.out.println("*******************************************************");
    System.out.println("Using the enhanced for loop once more again....");    
    for(String s: myList){
      System.out.println(s);
    }
  }
}