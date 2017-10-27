package exercise7;

/**
 * Class that implements a Deque with a Double Linked List.
 *
 * @author DIT-UC3M
 *
 */
public class DLDqueue implements Dqueue {
	private int size;
	/*
	 * Dummy nodes
	 */
	private DNode head; 
	private DNode tail; 

	public DLDqueue() {
    	head = new DNode();
    	tail = new DNode();
    	head.setNext(tail);
    	tail.setPrev(head);
    	size = 0;
	}

	public void insertFirst(Object obj) {
		System.out.println("insertFirst " + obj.toString());
		DNode n = new DNode(obj, head.getNext(), head);
		head.getNext().setPrev(n);
		head.setNext(n);	
		size++;

		System.out.println(toString());
	}

	public void insertLast(Object obj) {
		System.out.println("insertLast " + obj.toString());
		DNode n = new DNode(obj, tail, tail.getPrev());
		tail.getPrev().setNext(n);
		tail.setPrev(n);
		size++;
		System.out.println(toString());
	}

	public Object removeFirst() {
		if (size == 0) {
			return null;
		}
		
		DNode first = head.getNext();
		first.getNext().setPrev(head);
		head.setNext(first.getNext());
		size--;
		System.out.println("removeFirst " + first.getVal().toString());
		System.out.println(toString());
		return first.getVal();
	}

	public Object removeLast() {
		if (size == 0) {
			return null;
		}
		
		DNode last = tail.getPrev();
		last.getPrev().setNext(tail);
		tail.setPrev(last.getPrev());
		size--;
		System.out.println("removeLast " + last.getVal().toString());
		System.out.println(toString());
		return last.getVal();
	}

	public int size() {
	    return size;
	}

	public String toString() {
		String result = "Size " + size + ": ";
		DNode current = head;
		
		for (int i = 0; i < size; i++) {
			current = current.getNext();
			result += current.getVal().toString() + " ";
		}
		return result + "\n";
	}

	public static void main(String [] args)
	{
		DLDqueue deque = new DLDqueue();
		
		deque.insertFirst(2);
		deque.insertFirst(3);
		deque.insertFirst(4);
		
		deque.insertLast(5);
		deque.insertLast(6);
		
		deque.removeFirst();
		
		deque.removeLast();
		deque.removeLast();
		
		deque.removeFirst();
		deque.removeFirst();
		deque.removeFirst();
	}

}

