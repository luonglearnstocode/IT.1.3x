package exercise3;


class QueueException extends Exception {
	public QueueException(String message) {
		super(message);
	}
}

/**
 * Universidad Carlos III de Madrid
 * Departamento de Ingenieria Telematica.
 * Int queue
 * 2017
 */


/**
  * Int Queue
  */
public class Queue{

    /** Max num elements*/
    private int numElements;

    /** Array to save elements **/
    private int elements[];

    /** Indice to last element */
    private int last;

    /** Constructor to init the state object */
    Queue(int numElements){

        this.numElements = numElements;
        // Im java the first position in array is 0.
        last = -1;
        elements = new int [numElements];
    }

    /** Is empty the queue? */
    public boolean isEmpty(){
        return (last == -1);
    }

    /** Is full the queue */
    public boolean isFull(){
        return (last == numElements-1);
    }

    /** Insert an element in the queue */
    public void enqueue(int element){
    	last ++;
		elements[last] = element;
    }

    /** Extract the element in the queue.
     *  There isn't control error */
    public int dequeue(){
        int element = elements[0];

        // We dequeue the element at array position 0 then we must move
        // the rest of elements one position minus in the array.
        for (int i=0;i<last;i++) elements[i] = elements[i+1];

        last--;
        return element;
    }

    /** Returns the number of elements in the queue */
    public int numElements(){
        return last+1;
    }

    /** Print the elements in the queue*/
    public void print(){
        for (int i=0; i<=last; i++)
            System.out.print(elements[i] + "-");
        System.out.println();
    }

   public static void main(String args[]){
     // Five elements maximun in the queue
     
	   NaturalQueue queue = new NaturalQueue(5);

     System.out.println("Is empty?: " + queue.isEmpty());
     queue.enqueue(-1);
     queue.enqueue(2);
     queue.enqueue(3);
     queue.enqueue(4);
     queue.enqueue(5);
     System.out.println("Is full?: " + queue.isFull());

     System.out.println("Elemento: " + queue.dequeue());
     System.out.println("Elemento: " + queue.dequeue());
     System.out.println("Elemento: " + queue.dequeue());
     System.out.println("Elemento: " + queue.dequeue());
     System.out.println("Elemento: " + queue.dequeue());

     System.out.println("Is empty?: " + queue.isEmpty());
     
   } // main

} // Queue


// Implements the necessary class
class NaturalQueue extends Queue {

	NaturalQueue(int numElements) {
		super(numElements);
	}
	
	public void enqueue(int element) {
		if (element >= 0) {
			super.enqueue(element);
		}
	}
	
}

