package exercise4;

public class MyLinkedList<E>{
    private Node<E> first;
    
    public MyLinkedList(){
	    this.first = null;
    }
    
    /*
     * Insertion at the beginning
     */
    public void insert(E info){
	    Node<E> newNode = new Node<E>(info);
	    newNode.setNext(first);
	    first = newNode;
    }
    /*
     * Delete the first occurrence of a value 
     * Return a boolean stating if the delete was successful
     */
    public boolean deleteFirstOccurrence(E info){
        Node<E> current = first;
        if (first.getInfo().equals(info)) { // list of 1 element
        	first = first.getNext();
        	return true;
        }
        
        while (current.getNext() != null) { // list of more than 2 elements
        	if (current.getNext().getInfo().equals(info)) {
        		current.setNext(current.getNext().getNext());
        		return true;
        	}
        	current = current.getNext();
        }
        return false;
    }
    /*
     * Delete all the occurrences of a value
     * Returns the number of deleted nodes
     * You can use deleteFirstOccurrence
     */
    public int deleteAll(E info){
    	int number = 0;

        while (this.deleteFirstOccurrence(info)) {
        	number++;
        }
        
        return number;
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

