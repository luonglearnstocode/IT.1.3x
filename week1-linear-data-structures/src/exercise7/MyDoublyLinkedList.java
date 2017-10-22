package exercise7;

import exercise7.Node;

public class MyDoublyLinkedList<E extends Comparable<E>>{
    private Node<E> head;
    private Node<E> tail;
    
    public MyDoublyLinkedList(){
	    this.head = null;
	    this.tail = null;
    }
    
    /*
     * Insertion at the beginning
     */
    public void insert(E info){
	    Node<E> newNode = new Node<E>(info);
	    newNode.setNext(head);
	    if (head != null){
	        head.setPrev(newNode);
	    }
	    head = newNode;
	    if (tail == null){
	        tail = newNode;
	    }
    }
    /*
     * Insertion at the end 
     */
    public void insertEnd(E info){
	    Node<E> newNode = new Node<E>(info);
	    if (tail == null){
            head = newNode;
	        tail = newNode;
	    }else{
            tail.setNext(newNode);
            newNode.setPrev(tail);
	        tail = newNode;
	   }
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
	        } else {
	        	head.setPrev(null);
	        }
	    }
        
        return data;
    }
    /*
     * Extraction of the last node
     */
    public E extractEnd(){
    	E data = null;
        
        if (tail != null){
        	data = tail.getInfo();
        	
        	if (head == tail) { // list of 1 item
        		head = null;
        		tail = null;
        	} else {
        		tail = tail.getPrev();
        		tail.setNext(null);
        	}
	    }
        
        return data;
    }
    
    /*
     * Delete all nodes with info equal to value
     * returns number of deleted nodes
     */
     public int deleteAll(E info){
         int deleted = 0;
         
         Node<E> current = head;
         
         while (current != null) {
        	 if (current.getInfo().equals(info)) {
        		 deleted++;
        		 
        		 if (current == head && current == tail) {
        			 head = null;
        			 tail = null;
        		 } else if (current == tail) {
        			 tail = current.getPrev();
        			 current.getPrev().setNext(null);
        		 } else if (current == head) {
        			 head = current.getNext();
        			 current.getNext().setPrev(null);
        		 } else {
        			 current.getPrev().setNext(current.getNext());
        			 current.getNext().setPrev(current.getPrev());
        		 }   		 		 
        	 }
        	 
        	 current = current.getNext();
         }
         
         return deleted;
     }
     
    /*
     * Print all list forward
     */
    public void print(){
	    Node<E> current = head;
	    
	    while (current != null){
	        System.out.print(current.getInfo() + " ");
	        current = current.getNext();
	    }
	    System.out.println();
    }
    
    /*
     * Print all list backwards
     */
    public void printBackwards(){
	    Node<E> current = tail;
	    
	    while (current != null){
	        System.out.print(current.getInfo() + " ");
	        current = current.getPrev();
	    }
	    System.out.println();
    }
}

