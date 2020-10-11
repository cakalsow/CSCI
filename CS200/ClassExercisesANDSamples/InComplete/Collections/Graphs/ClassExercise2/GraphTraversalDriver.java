import java.util.*;
import java.io.*;
import datastructures.*;

public class GraphTraversalDriver{
  
  public static void displayGraphInfo(Graph g){
    System.out.println("Graph g has " + g.getNumV() + " vertices");
    System.out.println(); 
    System.out.println("Is graph directed?  " + g.isDirected());
    System.out.println();
    System.out.println("Show all edges:");
    for(int v = 0; v<g.getNumV();v++){
      Iterator iter = g.edgeIterator(v);
      while(iter.hasNext())
        System.out.println(iter.next());
    }
    System.out.println();
    System.out.println("BFS traversal starting from 0 : " + GraphTraversal.breadthFirstSearch(g,5));
    System.out.println();
    System.out.println("DFS traversal starting from 0 : " +  GraphTraversal.depthFirstSearch(g,5));
  }
  
  public static void main(String[] args){
    try{
      //Graph g = AbstractGraph.createGraph(new Scanner(new File(args[0])),false,"LiST");
      Graph g = AbstractGraph.createGraph(new Scanner(new File("datafile2")),false,"LiST");
      GraphTraversalDriver.displayGraphInfo(g);
      
    }
    catch(IOException ioe){
      System.out.println("Invalid file name specified");
    }
  }
  
}