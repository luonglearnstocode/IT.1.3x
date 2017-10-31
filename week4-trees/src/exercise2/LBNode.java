package exercise2;

public class LBNode<E> {

    // Attributes
    private E info;
    private BTree<E> left;
    private BTree<E> right;
    
    /*
     * Constructor
     */
    public LBNode(E info, BTree<E> left, BTree<E> right) {
    	this.info = info;
    	this.left = left;
    	this.right = right;
    }
    
    /* 
     * Access methods
     */
    public E getInfo() {
        return this.info;
    }
    
    public void setInfo(E info) {
        this.info = info;
    }
    
    public BTree<E> getLeft() {
    	return this.left;
    }
    
    public void setLeft(BTree<E> left) {
    	this.left = left;
    }
    
    public BTree<E> getRight() {
    	return this.right;
    }
    
    public void setRight(BTree<E> right) {
    	this.right = right;
    }

}
