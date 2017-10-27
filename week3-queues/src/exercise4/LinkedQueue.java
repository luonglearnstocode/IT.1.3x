package exercise4;

public class LinkedQueue<E> implements Queue<E> {
	   private int size;
	   private Node<E> head;
	   private Node<E> tail;
	   

	    public LinkedQueue(){
	    	head = null;
	    	tail = null;
	    	size = 0;
	    }

	    public boolean isEmpty() {
	        return size == 0;
	    }

	    public int size() {
	        return size;
	    }

	    public E front() {
	    	if (head == null)
	    		return null;
	    	else
	    		return head.getInfo();
	    }

	    public void enqueue (E info) {
	        Node<E> n = new Node(info);
	        if (tail == null)  // empty queue
	        	head = n;
	        else 
	        	tail.setNext(n);
	        tail = n;
	        size++;
	    }

	    public E dequeue(){
	    	if (isEmpty())
	    		return null;
	    	
	    	E element = head.getInfo();
	    	head = head.getNext();
	    	if (--size == 0) {
	    		tail = null;
	    	}
	    	
	    	return element;
	    }
	    
	    
	    public static void main(String [] args)
	    {
	        
	        LinkedQueue<Integer> q = new LinkedQueue<Integer>();   
	        
	        q.enqueue(1);
	        q.enqueue(2);
	        q.enqueue(3);
	        q.enqueue(4);
	        q.enqueue(5);
	        
	        System.out.println("Size: " + q.size()); 
	        
	        Integer e = q.front(); 
	        System.out.println("Size: " + q.size()); 
	        System.out.println(e); 
	        
	        e = q.dequeue();
	        e = q.dequeue();
	        System.out.println("Size: " + q.size()); 
	        
	        e = q.dequeue();
	        e = q.dequeue();
	        e = q.dequeue();
	        System.out.println("Size: " + q.size() + " isEmpty: " + q.isEmpty()); 
	        
	        
	    }
	}
