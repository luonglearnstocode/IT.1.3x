package exercise1;

/**
 * Universidad Carlos III de Madrid
 * Departamento de Ingenieria Telematica.
 * Int queue
 * 2017
 */

/* Class Exception to manage errors */
class QueueException extends Exception{
	
	QueueException(String message)
	{
		super(message);
	}
}

/**
  * Int Queue
  */
public class Queue{
        
    /** max number of elements*/
    private int numElements;

    /** Array to save elements **/
    private int elements[];

    /** Indice to first and last element */
    private int head;
    private int tail;

    /** Constructor to init the state object */
    Queue(int numElements){
    	this.numElements = numElements;
    	this.elements = new int[numElements];
    	head = -1;
    	tail = -1;
    }

    /** Is empty the queue? */
    public boolean isEmpty(){
        return tail == -1;
    }

    /** Is full the queue */
    public boolean isFull(){
        return tail == numElements - 1;
    }

    /** Insert an element in the queue 
     * @throws QueueException */
    public void enqueue(int element) throws QueueException {
    	if (isFull())
    		throw new QueueException("Queue is full");

    	elements[++tail] = element;
    }

    /** Extract the element in the queue.
     *  There isn't control error 
     * @throws QueueException */
    public int dequeue() throws QueueException {
    	if (isEmpty())
    		throw new QueueException("Queue is empty");

    	return elements[++head];
    }

    /** Returns the number of elements in the queue */
    public int numElements(){
        return tail - head;
    }

    /** Print the elements in the queue*/
    public void print(){
    	String toPrint = "Queue of " + numElements() + " element";
    	toPrint += (numElements > 1 ? "s:" : ":");
        for (int i = head + 1; i <= tail; i++) {
        	toPrint += (elements[i] + ".");
        }
        System.out.println(toPrint);
    }
        
    public static void main(String args[]){
 	   try{
 		   Queue queue = new Queue(3);
    
 		   queue.enqueue(1);
 		   queue.enqueue(2);
 		   queue.print();
 		   
 		   int e = queue.dequeue();
 		   System.out.println(e);
 		   queue.print();
 		   
 		   queue.enqueue(3);
 		   queue.print();
 		   
 		   // queue.enqueue(4);
 		   e = queue.dequeue();
 		   System.out.println(e);
 		   queue.print();
 		   
 		   queue.enqueue(4);
 		   queue.print();
 		   
 		   e = queue.dequeue();
 		   e = queue.dequeue();
 		   queue.print();
 		  
 		   // e = queue.dequeue();

 		   queue.enqueue(1);
 		   queue.enqueue(2);
 		   queue.print();
 		   
 	   }
 	   catch(QueueException ex){
 		   System.out.println(ex.getMessage());	
 	   }

    } // main

} // Queue
