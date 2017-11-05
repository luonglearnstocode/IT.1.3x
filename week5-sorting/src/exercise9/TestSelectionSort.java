package exercise9;

public class TestSelectionSort{
    /*This implementation searches the biggest and places it on the right*/
    public static void selectionSort(int a[]){
	    int n=a.length;
	    int numSwaps = 0;
	    int numIter = 0;
	    for (int i=0; i<(n-1); i++){ 
	        int m=0;
	        numSwaps++;
	        System.out.println(numSwaps + ": storing the biggest at "+(n-i-1));
	        System.out.println("\t\t\tLooking for the biggest one from 0 to "
			                    +(n-i-2));
	        System.out.println("\t\t\t\tThe biggest is a["+m+"] = "+a[m]);
	        for (int j=1; j<(n-i); j++){
	            numIter++;
		        if (a[j]>a[m]){
		            m=j;
		            System.out.println("\t\t\t\tThe biggest is a["+m+"] = "+a[m]);
		        }
	        }
	        if (n-1-i!=m){
	            swap(a,n-1-i,m);
	            System.out.print("\t\t\tSwap "+ numSwaps + "("+(n-1-i)+ "<->"+m+")"
	                            +": ");
	            print(a);
	        }
	    }
	    System.out.println("Num swaps: "+numSwaps+" Num iterations: "+numIter);
    }
    
    /* 
     Implement this method selecting the smallest one and placing it at the left
     and the largest and placing on the right in the same iteration */
    public static void selectionSortMinMax(int a[]){
    	int n=a.length;
	    int numSwaps = 0;
	    int numIter = 0;
	    
	    for (int i = 0; i < (n-1); i++) {
	    	int min = i;
	    	int max = n-1-i;
	    	if (min >= max) break;
	    	
	    	for (int j = i; j < (n-i); j++) {
	    		numIter++;
	    		if (a[j] > a[max]) max = j;
	    		if (a[j] < a[min]) min = j;
	    	}
	    	
//	    	System.out.println("i : " + i);
//	    	System.out.println("min " + min + " : " + a[min]);
//	    	System.out.println("max " + max + " : " + a[max]);
	    	
	    	if (max == i) {
	    		swap(a, max, n-1-i);
	    		swap(a, min, i);
	    	} else {
		    	swap(a, min, i);
		    	swap(a, max, n-1-i);
	    	}
	    	numSwaps += 2;

	    	
	    }
	    System.out.println("Num swaps: "+numSwaps+" Num iterations: "+numIter);
    }

   
    private static void swap(int a[], int pos1, int pos2){
    	System.out.println("Swap a[" + pos1 + "] with a[" + pos2 + "]");
	    int tmp = a[pos1];
    	a[pos1] = a[pos2];
	    a[pos2] = tmp;
	    print(a);
    }
    
    private static void print(int a[]){
	    for (int i=0; i < a.length; i++){
	        System.out.print(a[i]+" ");
	    }
	    System.out.println();
    }
    
    public static void main(String args[]){

	    int array[] = {7,5,1,2,3,6,4};
	    System.out.print("Unsorted Array: ");
	    print(array);
	    selectionSort(array);
	    System.out.print("Final Output SelectionSort: ");
	    print(array);
        /* Comment out the following lines to test your code */
	    
	    array = new int[]{7,5,1,2,3,6,4};
	    System.out.print("Unsorted Array: ");
	    print(array);
	    selectionSortMinMax(array);
	    System.out.print("Final Output SelectionSort: ");
	    print(array);
	    
	   
    }
}

