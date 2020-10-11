import java.io.*;

public class DirectoryStructure{
  
  //COMPLETE ME EXERCISE 1: *******************************************************************************************
  private void getDirectoryContent1(String filePath, int depth) {
    String indent = "";
    for (int d=0;d<depth;d++)
      indent += ">";
    
    //converts a String path to a File object
    File currentDirOrFile = new File(filePath);
    
    /**
     * Here is the logic:
     * CASE 1: Encounter a file: 
     *           (1) print its name preceded with the proper indentation
     */    
    if ( currentDirOrFile.isFile() ){
      
    }
    /* CASE 2: else it must be a directory: 
     *           (1) print its name preceded with the proper indentation
     *           (2) loop over contents and call method recursively with depth + 1
     */ 
    else{
    }  
  }
  
  
  //COMPLETE ME EXERCISE 2: *******************************************************************************************  
  //redo method above but now using a String indent parameter that would contain the needed indentation instead of an 
  // integer. In other words, a "> " should be added for every new level
  private void getDirectoryContent2(String filePath, String indent) {
    return;
  }
  public static void main (String args [] ){
    // Here you pass the path to the directory to be scanned
    System.out.println("\nUsing getDirectoryContent1(String filePath, int depth) : \n");
    (new DirectoryStructure()).getDirectoryContent1("/usr/people/classes/CS200/labs",0);
    System.out.println("\nUsing getDirectoryContent2(String filePath, String indent) : \n");
    (new DirectoryStructure()).getDirectoryContent2("/usr/people/classes/CS200/labs","");
    System.out.println("\naccessing an invalid directory : \n");
    (new DirectoryStructure()).getDirectoryContent2("/usr/p","");
  }
}
