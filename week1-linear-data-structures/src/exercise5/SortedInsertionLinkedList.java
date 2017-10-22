package exercise5;

/*
* Exercise for inserting in a sorted way (lowest to highest)
* elements within a linked list
*/
public class SortedInsertionLinkedList{

   public static void main(String args[]){
       // Create a linked list using MyLinkedList<Integer>
	    MyLinkedList<Integer> mine = new MyLinkedList<Integer>();
	   // Insert 10 ints 
	    for (int i=0; i< 100; i++){
	    	int n = (int)(100*Math.random());
//	    	System.out.println("n = " + n);
	        mine.insert(n);
//	        mine.print();
	    }
	    
	    //Print the whole list
	    System.out.println("######################################");
	    mine.print();
   }
}

