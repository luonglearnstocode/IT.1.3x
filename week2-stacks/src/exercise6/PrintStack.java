package exercise6;

public class PrintStack{

	  /** Recursive algorithm to print a Stack */
	  private static void print(LinkedStack<Integer> p)
	  {
	    // TODO 
		  if (p.isEmpty())
			  return;
		  
		  Integer x = p.pop();
		  System.out.println(x);
		  print(p);
		  p.push(x); // restore the stack state
		  
	  } // print


	  public static void main(String [] args)
	  {
	    LinkedStack<Integer> p = new LinkedStack<Integer>();

	    p.push(1);
	    p.push(2);
	    p.push(3);
	    p.push(4);
	    p.push(5);

	    System.out.println("Stacks elements:");
	    print(p);

	  } // main
	    
}
