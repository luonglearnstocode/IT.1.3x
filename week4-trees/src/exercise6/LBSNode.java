package exercise6;

public class LBSNode<E> {

	  // Attributes
	  private Comparable key;
	  private E info;
	  
	  private BSTree<E> right;
	  private BSTree<E> left;
	  
	  public LBSNode(Comparable key, E info, BSTree<E> left, BSTree<E> right) {
		  this.key = key;
		  this.info = info;
		  this.left = left;
		  this.right = right;
	  }
	  
	  // Access methods
	  
	  public void setKey(Comparable key) {
		  this.key = key;
	  }
	  
	  public Comparable getKey() {
		  return key;
	  }
	  
	  public void setInfo(E info) {
		  this.info = info;
	  }
	  
	  public E getInfo() {
		  return info;
	  }
	  
	  public void setLeft(BSTree<E> left) {
		  this.left = left;
	  }
	  
	  public BSTree<E> getLeft() {
		  return left;
	  }
	  
	  public void setRight(BSTree<E> right) {
		  this.right = right;
	  }
	  
	  public BSTree<E> getRight() {
		  return right;
	  }

	  /* 
	   * Returns a String representation
	   */
	  public String toString() {
		return key.toString()+"/"+info.toString();
	  }   
	  
	}

