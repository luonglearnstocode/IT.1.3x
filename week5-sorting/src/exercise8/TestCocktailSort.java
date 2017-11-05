package exercise8;

public class TestCocktailSort{
    
    /* This is the algorithm from the video */
    public static void bubbleSort(int[] a){
	    int n=a.length;
	    int nIter=0;
	    int nSwaps = 0;
	    int nPasses = 0;
	    for(int i=0; i<n; i++){
	        nPasses++;
	        for(int j=1; j<(n-i); j++){
	            nIter++;
		        if(a[j-1]>a[j]){
		            nSwaps++;
		            swap(a,j-1,j);
		        }
	        }
	    }
	    System.out.println("Num Passes: "+nPasses+
	                        " Num Iter: "+nIter+" Num Swaps: "+nSwaps);
    }
    
    public static void cocktailSort( int[] a ){
	    boolean swapped;
	    int numIter=0;
	    int numSwaps=0;
	    int numPasses=0;
	    do {
	        numPasses++;
	        swapped = false;
	        for (int i =0; i<=  a.length  - 2;i++) {
		        numIter++;
		        if (a[i] > a[i+1]){
		            numSwaps++;
		            swap(a,i,i+1);
		            swapped = true;
		        }
	        }
	        //we can exit the outer loop here if no swaps happened.
	        if (swapped) {
		        swapped = false;
		        for (int i= a.length - 2;i>=0;i--) {
		            numIter++;
		            if (a[i] > a[i+1]) {
			            numSwaps++;
			            swap(a,i,i+1);
			            swapped = true;
		            }
		        }
	        }
	        //if no elements have been swapped, then the list is sorted
	    } while (swapped);
	    System.out.println("Num Passes: "+numPasses+ " Num Iter: "+numIter
		            	   +" Num Swaps: "+numSwaps);
    }    
    
    /*Implement this method */
    public static void optimisedCocktailSort( int[] a ){
    	int n = a.length;
    	int m;
    	int numIter = 0;
	    int numSwaps = 0;
	    int numPasses = 0;
	    
    	while (n != 0) {
    		numPasses++;
    		m = 0;
    		for (int i = 1; i < n; i++) {
    			numIter++;
    			if (a[i] < a[i-1]) {
    				numSwaps++;
    				swap(a, i, i-1);
    				m = i;
    			}
    		}
    		
    		n = m;
    	}
    	System.out.println("Num Passes: "+numPasses+ " Num Iter: "+numIter
         	   +" Num Swaps: "+numSwaps);
    }
    
    private static void swap(int a[], int pos1, int pos2){
	    int tmp = a[pos1];
    	a[pos1] = a[pos2];
	    a[pos2] = tmp;
    }
    
    private static void print(int a[]){
	    for (int i=0; i < a.length; i++){
	        System.out.print(a[i]+" ");
	    }
	    System.out.println();
    }
    
    public static void main(String args[]){

	    System.out.println("**********************************************");
    	int array[] = {7,5,1,2,3,6,4};
        System.out.print("\t\t\tUnsorted Array: ");
	    print(array);
	
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println("Bubble Sort: ");
	    bubbleSort(array);
    	print(array);
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    array = new int[]{7,5,1,2,3,6,4};
	    System.out.println("Cocktail Sort: ");
	    cocktailSort(array);
	    print(array);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    array = new int[]{7,5,1,2,3,6,4};
	    System.out.println("Optimised Cocktail Sort: ");
	    optimisedCocktailSort(array);
	    print(array);

        System.out.println("**********************************************");
        array = new int[]{2,3,4,1,5,6,7};
        System.out.print("\t\t\tUnsorted Array: ");
	    print(array);

	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println("Bubble Sort: ");
	    bubbleSort(array);
    	print(array);
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		array = new int[]{2,3,4,1,5,6,7};
	    System.out.println("Cocktail Sort: ");
	    cocktailSort(array);
	    print(array);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    array = new int[]{2,3,4,1,5,6,7};
	    System.out.println("Optimised Cocktail Sort: ");
	    optimisedCocktailSort(array);
	    print(array);

        System.out.println("**********************************************");
    	array = new int[]{1,2,3,4,5,6,7};
	    System.out.print("\t\t\tUnsorted Array: ");
	    print(array);

	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println("Bubble Sort: ");
	    bubbleSort(array);
    	print(array);
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    array = new int[]{1,2,3,4,5,6,7};
	    System.out.println("Cocktail Sort: ");
	    cocktailSort(array);
	    print(array);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        array = new int[]{1,2,3,4,5,6,7};
        System.out.println("Optimised Cocktail Sort: ");
	    optimisedCocktailSort(array);
	    print(array);
	    
	    System.out.println("**********************************************");
    	array = new int[]{7,6,5,4,3,2,1};
	    System.out.print("\t\t\tUnsorted Array: ");
	    print(array);

	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println("Bubble Sort: ");
	    bubbleSort(array);
    	print(array);
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    array = new int[]{7,6,5,4,3,2,1};
	    System.out.println("Cocktail Sort: ");
	    cocktailSort(array);
	    print(array);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        array = new int[]{7,6,5,4,3,2,1};
        System.out.println("Optimised Cocktail Sort: ");
	    optimisedCocktailSort(array);
	    print(array);
	    
	    System.out.println("**********************************************");
	    array = new int[]{2,3,4,5,1};
	    System.out.print("\t\t\tUnsorted Array: ");
	    print(array);

	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println("Bubble Sort: ");
	    bubbleSort(array);
    	print(array);
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    array = new int[]{2,3,4,5,1};
	    System.out.println("Cocktail Sort: ");
	    cocktailSort(array);
	    print(array);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        array = new int[]{2,3,4,5,1};
        System.out.println("Optimised Cocktail Sort: ");
	    optimisedCocktailSort(array);
	    print(array);
	
    }
}

