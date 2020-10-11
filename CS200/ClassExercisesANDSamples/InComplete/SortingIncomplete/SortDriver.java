import java.util.*;

public class SortDriver{
  public static void arrayDisplayer(Integer[] array){
    System.out.print("[ ");
    for(int i=0; i<array.length; i++)
      System.out.print(array[i] + " ");
    System.out.println("]\n");
  }
  
//driver method
  public static void main(String[] args){
    
    Integer [] notSorted = {50,60,45,30,90,20,80,15,2,100};
    System.out.print("ARRAY BEFORE SORTING  :");
    arrayDisplayer(notSorted);
    
    //sort array via MergeSort
    Integer [] mergeSorted = notSorted.clone();
    MergeSort.sort(mergeSorted);
    System.out.print("ARRAY AFTER MERGE SORT:");
    arrayDisplayer(mergeSorted);
    
    //sort array via QuickSort
    Integer [] quickSorted = notSorted.clone();
    QuickSort.sort(quickSorted);
    System.out.print("ARRAY AFTER QUICK SORT:");
    arrayDisplayer(quickSorted);
    
  }
}