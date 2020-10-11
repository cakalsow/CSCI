package mydatastructures;

public class BinarySearchTreesWithRotations < E extends Comparable<E> > implements BSTInterface <E>{
  
  protected BSTNode root;
  
  
  public BinarySearchTreesWithRotations() {
    root = new BSTNode();
  }
  
  public BinarySearchTreesWithRotations(BSTNode root) {
    this.root = root;
  }
  
  
  public boolean add(E element) {
    return root.add(element);
  }
  
  public String toString() {
    return root.toString(0);
  }
  //No rotations should happen if root doesn't have a right child
  public void rotateLeft() {
    //COMPLETE ME **********************************************************
  }
  
  //No rotations should happen if root doesn't have a left child
  public void rotateRight() {
    //COMPLETE ME **********************************************************
  }   
  
  
  /** Class to encapsulate a BST node. */
  private  class BSTNode  {
    
    /** The information stored in this node. */
    private E element;
    
    /** Reference to the left child. */
    private BSTNode left;
    
    /** Reference to the right child. */
    private BSTNode right;
    
    private BSTNode() {
    }
    
    private BSTNode(E element) {
      this.element = element;
    }
    
    private BSTNode(E element, BSTNode left, BSTNode right){
      this.element = element;
      this.left = left;
      this.right = right;
    }
    
    private boolean isTerminal(){
      return this.element == null && this.left == null && this.right == null;
    }  
    
    public String toString() {
      return this.element.toString();
    }
    
    
    private boolean add(E element){
      if (this.isTerminal()){
        //System.out.println("FOUND SPOT");
        this.element = element;
        this.left = new BSTNode();
        this.right = new BSTNode();
        return true;
      }
      else{
        int comp = this.element.compareTo(element);
        if(comp>0){
          //System.out.println("WENT LEFT");
          return this.left.add(element);}
        else if(comp<0){
          //System.out.println("WENT RIGHT");
          return this.right.add(element);
        }
        else{
          //System.out.println("DUPLICATE");
          return false;}
      }
    }
    
    private String toString(int depth){
      //indent tree nodes properly to look like a tree
      String result = "";
      for (int i = 0; i <= depth; i++) {
        result +=("> ");
      }
      if (this.isTerminal())
        return result + "X \n";
      else 
        return result + this.element + "\n" + this.left.toString(depth+1)+ this.right.toString(depth+1);     
    }  
  }  
}
