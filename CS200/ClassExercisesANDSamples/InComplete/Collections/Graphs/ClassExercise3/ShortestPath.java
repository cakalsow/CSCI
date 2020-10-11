import java.io.*;
import java.util.*;
import datastructures.*;
public class ShortestPath {
  
 public static int[] breadthFirstSearch(Graph graph, int start) {
    Queue < Integer > theQueue = new LinkedList < Integer > ();
    // Declare array parent and initialize its elements to -1.
    int[] parent = new int[graph.getNumV()];
    for (int i = 0; i < graph.getNumV(); i++) {
      parent[i] = -1;
    }
    // Declare array identified
    boolean[] identified = new boolean[graph.getNumV()];
    /* Mark the start vertex as identified and insert it
       into the queue */
    identified[start] = true;
    theQueue.offer(start);
    /* While the queue is not empty */
    while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
      int current = theQueue.remove();
      /* Examine each vertex, neighbor, adjacent to current. */
      Iterator < Edge > itr = graph.edgeIterator(current);
      while (itr.hasNext()) {
        Edge edge = itr.next();
        int neighbor = edge.getDest();
        // If neighbor has not been identified
        if (!identified[neighbor]) {
          // Mark it identified.
          identified[neighbor] = true;
          // Place it into the queue.
          theQueue.offer(neighbor);
          //specify parent of neighbor
          parent[neighbor] = current;
        }
      }
      // Finished visiting current.
    }
    return parent;
  }
  
  public static void main(String[] args) {
    int numV = 0; // The number of vertices.
    Graph theGraph = null;
    // Load the graph data from a file.
    try {
      Scanner sC = new Scanner(new File("datafile2"));
      theGraph = AbstractGraph.createGraph(sC, false, "List");
      numV = theGraph.getNumV();
    }
    catch (IOException ex) {
      System.err.println("IO Error while reading graph");
      System.err.println(ex.toString());
      System.exit(1);
    }
    int START = 6;
    int END = 9;
    // Perform breadth-first search start from START
    int parent[] = ShortestPath.breadthFirstSearch(theGraph, START);
    
    // Construct the shortest path between START & END using parent[]
    // e.g., shortest path from 6 to 9
    //==> display: 
    // 6
    // 1
    // 2
    // 9
    //COMPLETE ME **********************************************************************
  }
}
