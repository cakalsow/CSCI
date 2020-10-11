import java.util.*;
import datastructures.*;

public class GraphTraversal{
  
  public static String breadthFirstSearch(Graph graph, int start) {
    //1-Use a queue initialized to start ... note that Java's LinkedList implements Queue Interface
    Queue<Integer> theQ = new LinkedList<Integer> ();
    // Array to store the visit status for each vertex; a true indicates that 
    // a vertex has been added to queue or visited before
    boolean[] seen = new boolean[graph.getNumV()];
    // append visited vertices to this String
    String visitSequence = "";
    theQ.offer(start);
    //2-Mark start as seen
    seen[start] = true;
    
    //COMPLETE ME **************************************************************************************************
    //3- Repeat following as long as queue is not empty
    //  3.1- Dequeue and visit
    //  3.2- Enqueue adjacent vertices (not seen before) marking each as seen
    while(!theQ.isEmpty()){
      int current = theQ.remove();
      visitSequence += current + "   ";
      Iterator<Edge> itr = graph.edgeIterator(current);
      while(itr.hasNext()){
        int n = itr.next().getDest();
        if(!seen[n]){
          theQ.offer(n);
          seen[n]=true;
        }
          
      }
        
      
    }
    
    return visitSequence;
  }
  
  public static String depthFirstSearch(Graph graph, int start){
    boolean[] visited = new boolean[graph.getNumV()];
    return depthFirstSearch(graph, start,visited);
  }
  
  private static String depthFirstSearch(Graph graph, int current,  boolean[] visited ) {
    String visitSequence= current + " ";
    //COMPLETE ME **************************************************************************************************
    // 1-Visit current vertex and mark it as visited
    // 2-For every neighbor not visited before, make recursive call appending returned value to visitSequence

    return visitSequence;
  }
}
