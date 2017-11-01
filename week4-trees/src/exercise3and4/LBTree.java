package exercise3and4;

public class LBTree<E> implements BTree<E> {
    
    // Attribute that represents the root node (recursive definition)
    private LBNode<E> root;

    /*
     * Constructor of an empty tree
     */
    public LBTree() {
        root = null;
    }
    
    /* 
     * Constructor
     */
    public LBTree(E info) {
        root = new LBNode<E>(info, new LBTree<E>(), new LBTree<E>());
    }
 
    /*
     * Checks if the tree is empty
     */
    public boolean isEmpty() {
        return (root == null);
    }
    
    /*
     * Returns the information stored in the node
     */
    public E getInfo() throws BTreeException {
        if (isEmpty()) {
            throw new BTreeException("Empty trees do not have info");
        }
        return root.getInfo();
    }
    
    /*
     * Returns left and right subtrees
     */
    public BTree<E> getLeft() throws BTreeException {
    	return root.getLeft();
    }
    
    public BTree<E> getRight() throws BTreeException {
    	return root.getRight();
    }

    /* 
     * Inserts a given tree as a subtree in the given side
     */
    public void insert(BTree<E> tree, int side) throws BTreeException {
        if (isEmpty()) {
            throw new BTreeException("Empty trees do not have a left or right child");
        }
        if(side==LEFT) {
            if (!root.getLeft().isEmpty()) {
                throw new BTreeException("Left subtree is not empty");
            }  
            root.setLeft(tree);
        } else {
        	if (!root.getRight().isEmpty()) {
                throw new BTreeException("Right subtree is not empty");
            }  
            root.setRight(tree);
        }
    }
    
    /*
     * Tree traversals (dummy implementations)
     */
    public String toStringPreOrder() {
//        System.out.println("Traverses the ["+root.getInfo()+"] tree in preorder");
    	if (root == null) return "";
        String toPrint = "";
        
        toPrint += root.getInfo().toString() + " ";
        toPrint += root.getLeft().toStringPreOrder();
        toPrint += root.getRight().toStringPreOrder();
        
        return toPrint;
    }
    
    public String toStringInOrder() {
//        System.out.println("Traverses the ["+root.getInfo()+"] tree in order");
    	if (root == null) return "";
    	
        String toPrint = "";
        
        toPrint += root.getLeft().toStringInOrder();
        toPrint += root.getInfo().toString() + " ";
        toPrint += root.getRight().toStringInOrder();
        
        return toPrint;
    }
    
    public String toStringPostOrder() {
//        System.out.println("Traverses the ["+root.getInfo()+"] tree in postorder");
    	if (root == null) return "";
    	
        String toPrint = "";
              
        toPrint += root.getLeft().toStringPostOrder();
        toPrint += root.getRight().toStringPostOrder();
        toPrint += root.getInfo().toString() + " ";
        
        return toPrint;
    }
    
    /*
     * Tree properties (dummy implementations)
     */
    public int size() {
//        System.out.println("Returns the size of ["+root.getInfo()+"] tree");
    	if (root == null) return 0;
    	return 1 + root.getLeft().size() + root.getRight().size();
    }
    
    public int height() {
//        System.out.println("Returns the height of ["+root.getInfo()+"] tree");
    	if (root == null) return -1;
    	return 1 + Math.max(root.getLeft().height(), root.getRight().height());
    }
    
}
