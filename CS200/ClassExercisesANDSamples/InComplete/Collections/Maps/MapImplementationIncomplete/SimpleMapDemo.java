import java.util.*;
import mydatastructures.*;

public class SimpleMapDemo
{
  public static void main( String[] args ){
    //MyHashMap<String,Double> map = new MyHashtableOpen<String,Double>();
    MyHashMap<String,Double> map = new MyHashtableChain<String,Double>();
    System.out.println( "Is map empty ? " + map.isEmpty() );
    System.out.println( "Map's size is  " + map.size() ); 
    System.out.println( "Map's contents " + map );
    System.out.println("*****************************************************************************************************");
    System.out.println( "Demonstrate 'put()' to add ('Alexis', 3.5)"  );   
    map.put( "Alexis", 3.5);
    System.out.println( "Demonstrate 'put()' to add ('Tyler', 3.8)"    );   
    map.put( "Tyler", 3.8);
    System.out.println( "Demonstrate 'put()' to add ('Nick', 3.5)"      ); 
    map.put( "Nick", 3.5);    
    System.out.println( "Demonstrate 'put()' to add ('Wilmot', 2.5)"     );  
    map.put( "Wilmot", 2.5);    
    System.out.println( "Demonstrate 'put()' to add ('James', 2.0)"   );    
    map.put( "James", 2.0);
    System.out.println( "Demonstrate 'put()' to add ('Sara', 3.5)"  );    
    map.put( "Sara", 3.5);
    System.out.println( "Demonstrate 'put()' to add ('Imad', 4.0)" );    
    map.put( "Imad", 4.0);
    System.out.println( "Is map empty ? " + map.isEmpty() );
    System.out.println( "Map's size  is " + map.size() );
    System.out.println( "Map's contents " + map );
    System.out.println("*****************************************************************************************************");
    System.out.println( "Demonstrate 'put()' to modify: map.put('James', 1.0)" );
    map.put("James", 1.0);
    System.out.println( "Map's contents " + map );
    System.out.println("*****************************************************************************************************");
    System.out.println( "Demonstrate 'get()'" );
    System.out.println( "map.get( James ) = " + map.get( "James") );
    System.out.println( "map.get( Alexis ) = " + map.get( "Alexis") );
    System.out.println( "map.get( Not here ) = " + map.get( "Not here") );
    System.out.println("*****************************************************************************************************");
    System.out.println( "Demonstrate 'containsKey()'" );
    System.out.println( "map.containsKey( Tyler ) = " + map.containsKey( "Tyler") );
    System.out.println( "map.containsKey( Not here ) = " + map.containsKey( "Not here") );
    System.out.println("*****************************************************************************************************");
    System.out.println( "Demonstrate 'containsValue()'" );
    System.out.println( "map.containsValue( 4.0 ) = " + map.containsValue( 4.0) );
    System.out.println( "map.containsValue( 3.1 ) = " + map.containsValue( 3.1) );    
    System.out.println("*****************************************************************************************************");
    System.out.println( "Demonstrate 'remove()': map.remove( 'James' )" );
    map.remove( "James" );
    map.remove( "Not here" );
    System.out.println( "Is map empty ? " + map.isEmpty() );
    System.out.println( "Map's size  is " + map.size() );
    System.out.println( "Map's contents " + map );  
    System.out.println("*****************************************************************************************************");
    System.out.println( "Demonstrate 'keySet()' to loop over keys & values " );
    Set<String> keys = map.keySet();
    System.out.print("{");
    for(String k: keys)
      System.out.println(k + "=" + map.get(k));
    System.out.println("}");
    System.out.println("*****************************************************************************************************");
  }
}



