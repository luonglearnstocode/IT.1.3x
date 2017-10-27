package exercise5;

public class CircularLinkedList {

	  // dummy node
	  private Node position;
	  private int size;

	  protected CircularLinkedList() {
		  position = new Node();
		  position.setNext(position); // at the beginning position's next node is itself
		  size = 0;
	  }

	  // if we need position in classes that extend this one
	  protected Node getPosition() {
		  return position;
	  }

	  // simple and self-explained code. Worth to reuse it
	  public boolean isEmpty() {
		  return size == 0;
	  }

	  // insert at the end, set next to position
	  public void insert(Object o) {
		  System.out.println("Inserting " + o.toString());
		  Node current = null;		  
		  for (current = position; current.getNext() != position; current = current.getNext()) {}
		  
		  Node n = new Node(o, position);
		  current.setNext(n);
		  size++;
		  
	  }

	  public Object extract() {
	    // look carefully which value is returned in each case
	    //
	    // 1 - if the list is empty, return null
	    // 2 - if the list has only one value,
	    // return the value and state that the list is empty
	    // 3 - if the list has more than one value,
	    // return the value that is next to 'position' and
	    // the Node that contained the returned Object.
	    //
	    // Look that in the third case, instead of returning the value of
	    // position, it is returned the next in the list. Why? Because it was
	    // easier to implement, nothing else. (draw it for a better understanding)
	    
		  
		  if (isEmpty()) 
			  return null;
		  Object o = position.getNext().getInfo();
		  position.setNext(position.getNext().getNext());
		  size--;
		  System.out.println("Extracting " + o.toString());
		  return o;
	  }

	  public String toString() {
		  String result = "";
		  Node current = position;
		  for (int i = 0; i < size; i++) {
			  current = current.getNext();
			  result += current.getInfo().toString() + " "; 			  
		  }		 
		  
		  return result;
	  }

	  public int size() {
		  return size;
	  }

	  public Object[] toArray() {
		  Object[] result = new Object[size];
		  Node current = position;
		  for (int i = 0; i < size; i++) {
			  current = current.getNext();
			  result[i] = current.getInfo(); 			  
		  }
		  
		  return result;
	  }
	  
	  public static CircularLinkedList getExample() {
		    CircularLinkedList out = new CircularLinkedList();

		    // a random int value from 0 to 9 (random never returns 1)
//		    int numberOfElements = (int) (Math.random() * 10);
		    int numberOfElements = 5;
		    // the list is filled with Integer values
		    //
		    // note: the Integer class is the object oriented representation of a int
		    // value
		    for (int i = 0; i < numberOfElements; i++) {
		      // the value ranges from -25 to 25
		      int value = (int) (Math.random() * 51) - 25;
		      out.insert(new Integer(value));
		    }
		    // printing this to stdout is not required. I do it just to track the code
		    System.out.println("Generada una CircularLinkedList de " + numberOfElements
		        + " elementos");
		    return out;
		  }
	  

}