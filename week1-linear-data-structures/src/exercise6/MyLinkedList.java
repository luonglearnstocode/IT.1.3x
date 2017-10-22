package exercise6;

public class MyLinkedList<E>{
    private Node<E> head;
    private Node<E> tail;
    
    public MyLinkedList(){
	    this.head = null;
	    this.tail = null;
    }
    
    /*
     * Insertion at the beginning
     */
    public void insert(E info){
	    Node<E> newNode = new Node<E>(info);
	    newNode.setNext(head);
	    head = newNode;
	    if (tail == null){
	        tail = newNode;
	    }
    }
    
    /*
     * Insertion at the end 
     * Implement this method
     */  
    public void insertEnd(E info){
    	Node<E> newNode = new Node<E>(info);
    	if (tail == null) {
    		tail = newNode;
    		head = tail;
    		return;
    	}
    	
	    tail.setNext(newNode);
	    tail = newNode;
    }
    
    /*
     * Extraction of the first node
     */
    public E extract(){
        E data = null;
        
        if (head != null){
	        data = head.getInfo();
	        head = head.getNext();
	        if (head == null) {
	        	tail = null;
	        }
	    }
        
        return data;
    }
    
    /*
     * Extraction of the last node
     * Implement this method
     */
    public E extractEnd(){
    	E data = null;
        
        if (tail != null){
        	data = tail.getInfo();
        	
        	if (head == tail) { // list of 1 item
        		head = null;
        		tail = null;
        	} else {
        		Node<E> current = head;
        		while (current.getNext() != tail) {
        			current = current.getNext();
        		}
        		tail = current;
        	}
	    }
        
        return data;
    }
    
    /*
     * Print all list
     */
    public void print(){
	    Node<E> current = head;
	    
	    while (current != null){
	        System.out.print(current.getInfo() + " ");
	        current = current.getNext();
	    }
	    System.out.println();
    }
}
