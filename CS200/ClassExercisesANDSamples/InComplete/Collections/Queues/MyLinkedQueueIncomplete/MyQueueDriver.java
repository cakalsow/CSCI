import datastructures.*;

import java.util.*;


public class MyQueueDriver {
  
  public static void main(String[] args) {
    
    MyQueue<String> nameQueue=new MyLinkedQueueImplementation<String>();
    MyQueue<String> ourNameIs=new MyLinkedQueueImplementation<String>();
    
    ourNameIs.enqueue("o");
    System.out.println("Enqueued     : " + ourNameIs.peek());
    ourNameIs.enqueue("u");
    System.out.println("Enqueued     : u");
    ourNameIs.enqueue("r");
    System.out.println("Enqueued     : r");
    ourNameIs.enqueue("n");
    System.out.println("Enqueued     : n");
    ourNameIs.enqueue("a");
    System.out.println("Enqueued     : a");    
    ourNameIs.enqueue("m");
    System.out.println("Enqueued     : m");
    ourNameIs.enqueue("e");
    System.out.println("Enqueued     : e");
    ourNameIs.enqueue("i");
    System.out.println("Enqueued     : i");
    ourNameIs.enqueue("s");
    System.out.println("Enqueued     : s");
    System.out.println("****************************************************************************");    
    System.out.println("Queue has been loaded ... iterating once using enhanced for loop :");
    for(String e : ourNameIs){
      System.out.print(e + " ");
    }
    
    nameQueue.enqueue("c");
    System.out.println("Enqueued     : " + nameQueue.peek());
    nameQueue.enqueue("h");
    System.out.println("Enqueued     : h");
    nameQueue.enqueue("a");
    System.out.println("Enqueued     : a");
    nameQueue.enqueue("n");
    System.out.println("Enqueued     : n");
    nameQueue.enqueue("n");
    System.out.println("Enqueued     : n");    
    nameQueue.enqueue("a");
    System.out.println("Enqueued     : a");
    nameQueue.enqueue("!");
    System.out.println("Enqueued     : !");
    System.out.println("****************************************************************************");    
    System.out.println("Queue has been loaded ... iterating once using enhanced for loop :");
    for(String e : nameQueue){
      System.out.print(e + " ");
    }
    System.out.println();    
    System.out.println("****************************************************************************");    
    System.out.println("Queue being emptied :");
    while(!nameQueue.isEmpty()){
      System.out.println("Dequeue :"  + nameQueue.peek());
      nameQueue.dequeue();
    }
    System.out.println();    
    System.out.println("****************************************************************************");    
    System.out.println("Queue being emptied :");
    while(!ourNameIs.isEmpty()){
      System.out.println("Dequeue :"  + ourNameIs.peek());
      ourNameIs.dequeue();
    }
    System.out.println("****************************************************************************");    
    try{
      nameQueue.dequeue();
    }
    catch(NoSuchElementException nsee){
      System.out.println("NoSuchElementException correctly caught when dequeuing from an empty queue");
    }
    
    try{
      nameQueue.peek();
    }
    catch(NoSuchElementException nsee){
      System.out.println("NoSuchElementException correctly caught when peeking on an empty queue");
    } 
    
    System.out.println("****************************************************************************");    
    System.out.println("Nothing left to interate over");
    for(String e : nameQueue){
      System.out.println("Value :"+e);
    }  
  }
}
