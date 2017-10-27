package exercise2;


/**
 * Universidad Carlos III de Madrid
 * Departamento de Ingenieria Telematica.
 * Int circular queue
 * 2017
 */

class QueueException extends Exception {
	public QueueException(String message) {
		super(message);
	}
}

/**
  * Int Queue
  */
public class Queue{

    /** Number of element in the queue */
    private int numElements;
    private int capacity;

    /** Array to save elements **/
    private int elements[];

    /** Indice to first & last element */
    private int head;
    private int tail;

    // Add one position and calculates if we must return the first position array.
    // Module opertion (%) is very important for this.
    private int next(int pos){
        return (pos+1) % (capacity+1);
    }


    /** Constructor to init the state object */
    Queue(int capacity){
        numElements = 0;
        this.capacity = capacity;
        // We must create the array with an extra element to control the conditions empty and full
        elements = new int [capacity+1];
        tail = 0;
        head = 0;
    }

    /** Is empty the queue? */
    public boolean isEmpty(){
        return numElements == 0;
    }

    /** Is full the queue */
    public boolean isFull(){
        return numElements == capacity;
    }

    /** Insert an element in the queue 
     * @throws QueueException */
    public void enqueue(int element) throws QueueException{
        if (isFull())
        	throw new QueueException("Queue is full");
        System.out.println("Enqueue " + element);
        elements[tail] = element;
        tail = next(tail);
        numElements++;
    }

    /** Extract the element in the queue.
     *  There isn't control error 
     * @throws QueueException */
    public int dequeue() throws QueueException{
    	if (isEmpty())
        	throw new QueueException("Queue is empty");
    	
    	int element = elements[head];
    	System.out.println("Dequeue " + element);
    	head = next(head);
    	numElements--;
        return element;
        
    }

    /** Returns the number of elements in the queue */
    public int numElements(){
        return numElements;
    }

    /** Print the elements in the queue*/
    public void print(){

        System.out.println("Head: " + head + " Tail: " + tail + " Number Elements: " + this.numElements);
        // from head to tail
        int i = head;
        for (int x = 0; x < numElements; x++)
        {
            System.out.println(elements[i] + "-");
            i = next(i);
        }
        System.out.println();
    }

    public static void main(String args[]){
     // Five elements maximun in the queue
    	try{
    		Queue queue = new Queue(5);

    		System.out.println("Is empty?: " + queue.isEmpty());
    		queue.enqueue(1);
    		queue.enqueue(2);
    		queue.enqueue(3);
    		queue.enqueue(4);
    		queue.enqueue(5);
    		queue.print();
    		System.out.println("Is full?: " + queue.isFull());
		
    		int e;
		
    		e = queue.dequeue();
    		e = queue.dequeue();
		
    		queue.print();
		
    		e = queue.dequeue();
    		e = queue.dequeue();
		
    		queue.print();
		
    		e = queue.dequeue();
		
    		queue.print();
		
    		queue.enqueue(1);
		
    		queue.print();
		
    		queue.enqueue(2);
    		queue.enqueue(3);
    		queue.enqueue(4);
    		queue.enqueue(5);
		
    		queue.print();
		
    		System.out.println("Is empty?: " + queue.isEmpty());
    		System.out.println("Is full?: " + queue.isFull());
    	}
  	   	catch(QueueException ex){
  	   		System.out.println(ex.getMessage());	
  	   	}

   } // main

} // Queue
