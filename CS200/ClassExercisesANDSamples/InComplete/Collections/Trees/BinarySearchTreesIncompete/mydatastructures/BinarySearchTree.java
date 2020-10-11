package mydatastructures;


public class BinarySearchTree < E extends Comparable <E> > implements BSTInterface <E>{
  
  //OUTER CLASS METHODS ARE ALL COMPLETE ******************************************************************************
  protected BSTNode root;
  
  public BinarySearchTree() {
    root = new BSTNode();
  }
  
  public BinarySearchTree(BSTNode root) {
    this.root = root;
  }
  
  public String preOrderTraverse() {
    //COMPLETE ME ***************************************************************************************************          
    return null;
  }
  
  public boolean contains(E target) {
    //COMPLETE ME ***************************************************************************************************          
    return false;
  } 
  
  public boolean add(E newElement) {
    //COMPLETE ME ***************************************************************************************************          
    return false;
  }
  
  public String postOrderTraverse() {
    //COMPLETE ME ***************************************************************************************************          
    return null;
  }
  
  public String inOrderTraverse() {
    //COMPLETE ME ***************************************************************************************************          
    return null;
  }
  
  public String toString() {
    //COMPLETE ME ***************************************************************************************************          
    return null;  
  }
  
  /** Class to encapsulate a BST node. */
  private  class BSTNode  {
    //SOME INNER CLASS METHODS ARE INCOMPLETE *************************************************************************
    /** The information stored in this node. */
    private E element;
    
    /** Reference to the left child. */
    private BSTNode left;
    
    /** Reference to the right child. */
    private BSTNode right;
    
    private BSTNode() {}
    
    private BSTNode(E element) {
      this.element = element;}
    
    private BSTNode(E element, BSTNode  left, BSTNode  right){
      this.element = element;
      this.left = left;
      this.right = right;}
    
    public String toString() {
      return this.element.toString();}
    
    private boolean isTerminal(){
      return this.element == null && this.left == null && this.right == null;
    }    
    
    /** 
     * starts at root and creates list displaying preorder traversal of tree
     * foreach node: 
     *     process node element,
     *     process left child recursively, and then
     *     process right child recursively.
     */    
    private String preOrderTraverse() {
      //COMPLETE ME ***************************************************************************************************          
      return "";     
    }  
    
    private boolean contains(E target) {
      //COMPLETE ME ***************************************************************************************************
      return false;
    } 
    
    private boolean add(E newElement){
      //COMPLETE ME ***************************************************************************************************
      return false;
    }
    
    
    /** 
     * starts at root and creates list displaying inorder traversal of tree
     * foreach node: 
     *     process left child recursively, 
     *     process node element, and then
     *     process right child recursively.
     */  
    private String inOrderTraverse() {
      //COMPLETE ME ***************************************************************************************************          
      return "";
    }  
    
    /** 
     * starts at root and creates list displaying postorder traversal of tree
     * foreach node: 
     *     process left child recursively, 
     *     process right child recursively,and then
     *     process node element,
     */    
    private String postOrderTraverse() {
      //COMPLETE ME ***************************************************************************************************    
      return "";
    }    
    
    /** 
     * Displays complete tree starting at root
     * Foreach node, it displays node element, followed by left child
     * followed by right child: THIS IS KNOWN AS PREORDER TREE
     * TRAVERSAL. It also includes proper indentation
     * 
     * For example the following BST (please note that X's denote empty terminal nodes)
     *                       12
     *                   /       \
     *                 9          17
     *               /   \        /  \
     *              8     11     X   25
     *            /  \   /  \       /  \  
     *           X   X  10   X     X    X
     *                 /  \
     *                X    X
     * would display like the following 
     * 
     * > 12
     * > > 9
     * > > > 8
     * > > > > X 
     * > > > > X 
     * > > > 11
     * > > > > 10
     * > > > > > X 
     * > > > > > X 
     * > > > > X 
     * > > 17
     * > > > X 
     * > > > 25
     * > > > > X 
     * > > > > X 
     */  
    private String toString(int depth){
      //create an indentation string (using depth parameter) to indent tree nodes properly in order to look like a tree 
      //indentation string should be printed before an element is
      String indentation = "";
      for (int i = 0; i <= depth; i++) {
        //???
      }
      //COMPLETE ME ***************************************************************************************************    
      return null;   
    }     
    
  }  
}
