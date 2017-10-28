package exercise8;

/*
 * Class that implements a Stack with a Deque
 *  
 * @author DIT-UC3M
 *
 */
public class DQStack implements Stack {

	private Dqueue data;

	public DQStack() {
		data = new DLDqueue();
	}

	public void push(Object obj) {
		data.insertFirst(obj);
	}

	public Object pop() {
		return data.removeFirst();
	}

	public int size() {
	    return data.size();
	}

	public String toString() {
		return data.toString();
	}

	public static void main(String[] args) {
    
		DQStack stack = new DQStack();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		System.out.println("Printing stack: " + stack);

		int s = stack.size();
		System.out.println("Printing size: " + stack.size());

		Object o = stack.pop();
		System.out.println("Pop element = " + o);

		System.out.println("Printing stack: " + stack);
		
		o = stack.pop();
		System.out.println("Pop element = " + o);

		System.out.println("Printing stack: " + stack);
		
		stack.push(4);
		System.out.println("Printing stack: " + stack);
		
		o = stack.pop();
		System.out.println("Pop element = " + o);

		System.out.println("Printing stack: " + stack);
    
	}
}

