import datastructures.*;

import java.util.*;


public class MyStackDriver {
  
  public static void main(String[] args) {
    
    MyStack<String> st=new MyLinkedStackImplementation<String>();
    
    st.push("a");
    System.out.println("After Push(a) ... Peek :"+st.peek());
    st.push("b");
    System.out.println("After Push(b) ... Peek :"+st.peek());
    st.push("c");
    System.out.println("After Push(c) ... Peek :"+st.peek());
    st.push("d");
    System.out.println("After Push(d) ... Peek :"+st.peek());
    st.push("e");
    System.out.println("After Push(e) ... Peek :"+st.peek());
    st.push("f");
    System.out.println("After Push(f) ... Peek :"+st.peek());
    System.out.println("****************************************************************************");    
    System.out.println("Stack has been loaded ... iterating once using enhanced for loop :");
    for(String s : st){
      System.out.print(s + " ");
    }
    System.out.println();
    System.out.println("****************************************************************************");    
    System.out.println("Stack has been loaded ... iterating twice using enhanced for loop :");
    for(String s : st){
      System.out.print(s + " ");
    }
    System.out.println();    
    System.out.println("****************************************************************************");    
    System.out.println("Stack being emptied :");
    while(!st.isEmpty()){
      System.out.println("Pop :"  + st.peek());
      st.pop();
    }
    System.out.println("****************************************************************************");    
    try{
      st.pop();
    }
    catch(NoSuchElementException nsee){
      System.out.println("NoSuchElementException correctly caught when poping from an empty stack");
    }
    
    try{
      st.peek();
    }
    catch(NoSuchElementException nsee){
      System.out.println("NoSuchElementException correctly caught when peeking on an empty stack");
    } 
    
    System.out.println("****************************************************************************");    
    System.out.println("Nothing left to interate over");
    for(String s : st){
      System.out.println("Value :"+s);
    }  
  }
}
