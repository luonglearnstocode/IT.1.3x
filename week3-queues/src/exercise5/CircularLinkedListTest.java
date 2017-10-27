package exercise5;

import java.util.Arrays;

public class CircularLinkedListTest {

	  public static void printArray(Object[] o) {
	    String s = "";
	    for (int i = 0; i < o.length; i++) {
	      s = s + o[i].toString() + " ";
	    }
	    System.out.println(s.trim());
	  }

	  public static void main(String args[]) {
	    CircularLinkedList cll = CircularLinkedList.getExample();
	    System.out.println(cll);
	    System.out.println(cll.size());
	    System.out.println(Arrays.toString(cll.toArray()));
	    printArray(cll.toArray());
	    
	    cll.extract();
	    cll.extract();
	    cll.extract();
	    System.out.println(cll);
	    System.out.println(cll.size());
	    
	    cll.insert(2);
	    cll.extract();
	    cll.extract();
	    cll.extract();
	    System.out.println(cll);
	    System.out.println(cll.size());
	  }
	}

