package exercise5;

public class MyLinkedList<E extends Comparable<E>>{
    // Notice that stating E extends Comparable<E> is needed, as we should use
    // compareTo for inserting in a sorted way
    private Node<E> first;
    
    public MyLinkedList(){
	    this.first = null;
    }
    
    /*
     * Insertion at the beginning
     * Change this method to insert the values in a sorted way
     */
    public void insert(E info){
	    Node<E> newNode = new Node<E>(info);
	    
	    if (first == null) { // empty list
	    	first = newNode;
	    	return;
	    } 
	    
	    if (newNode.getInfo().compareTo(first.getInfo()) < 0) { // insert at the beginning
    		newNode.setNext(first);
    	    first = newNode;
    	    return;
    	}
	    
	    if (first.getNext() == null) { // list of 1 item, insert at 2nd position
	    	first.setNext(newNode);
	    	return;
	    }
	    
	    // list of more than 2 elements
	    Node<E> current = first;
    	while (current.getNext() != null) {
    		if (newNode.getInfo().compareTo(current.getNext().getInfo()) < 0) {
    			newNode.setNext(current.getNext());
    			break;
    		}
    		current = current.getNext();
    	}
    	
	    current.setNext(newNode);
    }
    
    /*
     * Extraction of the first node
     */
    public E extract(){
	    E data = null;
	    if (first != null){
	        data = first.getInfo();
	        first = first.getNext();
	    }
	    return data;
    }
    /*
     * Print all list
     */
    public void print(){
	    Node<E> current = first;
	    
	    while (current != null){
	        System.out.print(current.getInfo() + " ");
	        current = current.getNext();
	    }
	    System.out.println();
    }
}

