import java.util.*;
import java.io.*;
import datastructures.*;

public class GraphDriver{
  
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
    System.out.println("is there an edge (0,3)? " + g.isEdge(0,3)) ;
    System.out.println("Test: g.getEdge(0,3):"+g.getEdge(0,3));
    System.out.println("is there an edge (0,5)? " + g.isEdge(0,5)) ;
    System.out.println("Test: g.getEdge(0,5):"+g.getEdge(0,5));
    System.out.println("is there an edge (5,0)? " + g.isEdge(5,0)) ;
    System.out.println("Test: g.getEdge(5,0):"+g.getEdge(5,0));     
    System.out.println();
    g.insert(new Edge(0,5,9.4));
     System.out.println("After insertion: g.insert(new Edge(0,5,9.4))");
    System.out.println("is there an edge (0,3)? " + g.isEdge(0,3)) ;
    System.out.println("Test: g.getEdge(0,3):"+g.getEdge(0,3));
    System.out.println("is there an edge (0,5)? " + g.isEdge(0,5)) ;
    System.out.println("Test: g.getEdge(0,5):"+g.getEdge(0,5));
    System.out.println("is there an edge (5,0)? " + g.isEdge(5,0)) ;
    System.out.println("Test: g.getEdge(5,0):"+g.getEdge(5,0));    
    System.out.println();
    g.insert(new Edge(0,5,10.4));   
    System.out.println("After insertion: g.insert(new Edge(0,5,10.4))");
    System.out.println("is there an edge (0,5)? " + g.isEdge(0,5)) ;
    System.out.println("Test: g.getEdge(0,5):"+g.getEdge(0,5));
    System.out.println("is there an edge (5,0)? " + g.isEdge(5,0)) ;
    System.out.println("Test: g.getEdge(5,0):"+g.getEdge(5,0));      
    System.out.println();
  }
  
  public static void main(String[] args){
    try{
      Graph g = AbstractGraph.createGraph(new Scanner(new File("datafileUnweighted")),true,"MaTRix");      
      GraphDriver.displayGraphInfo(g);
      
    }
    catch(IOException ioe){
      System.out.println("Invalid file name specified");
    }
  }
  
}