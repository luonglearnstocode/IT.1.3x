package exercise8;

import java.util.ArrayList;
import java.util.List;
/*
 * Lists II.
 */
 public class TestList{

    private static void printList(List<Integer> mine){
        for(Integer s : mine)
            System.out.print(s+" ");
        System.out.println();
    }
    private static List<Integer> createRandomList(int size, int max){
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i=0; i< size; i++){
            result.add( (int)( Math.random()*max));
        }
        return result;
    } 
    /*
     * You should implement this function without resorting to use HashSet
     * and maintaining the order of the List
     */
    private static void removeDuplicates(List<Integer> mine){
    	List<Integer> newList = new ArrayList<>();
    	
    	for (Integer i : mine) {
    		if (!newList.contains(i)) {
    			newList.add(i);
    		}
    	}
    	
    	mine.clear();
    	mine.addAll(newList);
    }
    
    public static void main(String args[]){
    	List<Integer> myList = createRandomList(10,5);
	    printList(myList);
	    //remove Duplicates from myList
	    removeDuplicates(myList);
	    printList(myList);
    }
}

