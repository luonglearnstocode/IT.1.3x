package exercise6;

public class LBSTree<E> implements BSTree<E> {
	
	/*
	 * Attribute: the node
	 */
	private LBSNode<E> root;
	private boolean isRemoved;
	
	/*
	 * Constructors
	 */
	public LBSTree(Comparable key, E info) {
		root = new LBSNode<E>(key, info, new LBSTree<E>(), new LBSTree<E>());
		isRemoved = false;
	}
	
	public LBSTree() {
		root = null;
		isRemoved = false;
	}
	
	/* 
	 * Checks if the tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/*
	 * Returns the search key of the information stored in the tree
	 */
	public Comparable getKey() {
		if(isEmpty()) {
			return null;
		} else {
			return root.getKey();
		}
	}
	
	/*
	 * Returns the information stored in the tree
	 */
	public E getInfo() {
		if(isEmpty()) {
			return null;
		} else {
			return root.getInfo();
		}
	}
	
	/* 
	 * Returns the left and right subtrees
	 */
	public BSTree<E> getLeft() {
		if(isEmpty()) {
			return null;
		} else {
			return root.getLeft();
		}
	}
	
	public BSTree<E> getRight() {
		if(isEmpty()) {
			return null;
		} else {
			return root.getRight();
		}
	}
	
	/*
	 * Inserts information into the tree. If key already exists, the information is overwritten
	 */
	public void insert(Comparable key, E info) {
		if(isEmpty()) {
			root = new LBSNode<E>(key, info, new LBSTree<E>(), new LBSTree<E>());
		} else {
			if(root.getKey().compareTo(key) > 0) {
				getLeft().insert(key, info);
			} else if(root.getKey().compareTo(key) < 0) {
				getRight().insert(key, info);
			} else {
				root.setInfo(info);
			}
		}
	}
	
	/*
	 * Searches for information in the tree
	 */
	public E search(Comparable key) {
		if (isEmpty()) return null;
		
		if(root.getKey().compareTo(key) > 0) {
			return getLeft().search(key);
		} else if(root.getKey().compareTo(key) < 0) {
			return getRight().search(key);
		} else {
			return isRemoved ? null : root.getInfo();
		}		
	}

	/*
	 * Searches and extracts information 
	 */
	public E extract(Comparable key) {
		if (isEmpty()) return null;
		
		if(root.getKey().compareTo(key) > 0) {
			return getLeft().extract(key);
		} else if(root.getKey().compareTo(key) < 0) {
			return getRight().extract(key);
		} else {
			if(!isRemoved) {
				isRemoved = true;
				return getInfo();
			} else {
				return null;
			}
		}	
	}
	
	/*
	 * Tree traversals 
	 */
	public String toStringPreOrder() {
		String toString = "";
		
		if (root == null) return "";
		toString += (isRemoved ? "" : root.toString() + " ") +
					getLeft().toStringPreOrder() +
					getRight().toStringPreOrder();
		
		return toString;
	}
	
	public String toStringInOrder() {
		String toString = "";
		
		if (root == null) return "";
		toString += getLeft().toStringInOrder() +
					(isRemoved ? "" : root.toString() + " ")  +
					getRight().toStringInOrder();
		
		return toString;
	}
	
	public String toStringPostOrder() {
		String toString = "";
		
		if (root == null) return "";
		toString += getLeft().toStringPostOrder() +
					getRight().toStringPostOrder() +
					(isRemoved ? "" : root.toString() + " ");
					
		
		return toString;
	}	
	
	/*
	 * Returns size of the tree (the number of pieces of information)
	 */
	public int size() {
		if (isEmpty()) return 0;
		return (isRemoved ? 0 : 1) + getLeft().size() + getRight().size();
	}
	
}
