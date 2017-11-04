package exercise6;

public class TestBubbleSort{
    
	   
    /* This is the algorithm from the video */
    public static void bubbleSort(int[] a){
	    int n=a.length;
	    int num_iter=0;
	    int nSwaps = 0;
	    for(int i=0; i<n; i++){
	        for(int j=1; j<(n-i); j++){
	            num_iter++;
		        if(a[j-1]>a[j]){
		            nSwaps++;
		            swap(a,j-1,j);
		        }
	        }
	    }
	    System.out.println("Num iterations: "+num_iter+" Num Swaps: "+nSwaps);
    }
    
    public static void bubbleSortOptimized(int[] a){
	    int n=a.length;
	    boolean swapped = true;
	    int i = 0;
	    int num_iter = 0;
	    int nSwaps = 0;
	    while ((i<n) && (swapped == true)){
	        swapped = false;
	        for(int j=1; j<(n-i); j++){
	            num_iter++;
		        if(a[j-1]>a[j]){
		            nSwaps++;
		            swap(a,j-1,j);
		            swapped = true;
		        }
	        }
	        i++;
	    }
	    System.out.println("Num iterations: "+num_iter+" Num Swaps: "+nSwaps);
    }
    
    /* Implement this algorithm */
    public static void bubbleSortMoreOptimized(int[] a){
    	int n=a.length;
	    int num_iter=0;
	    int nSwaps = 0;
	    int lastSwap = -1;
//	    for(int i=0; i<n; i++){
//	    	boolean swapped = false;
//	    	if (i == lastSwap) break;
//	        for(int j=1; j<(n-i); j++){
//	            num_iter++;
//		        if(a[j-1]>a[j]){
//		            nSwaps++;
//		            swap(a,j-1,j);
//		            swapped = true;
//		            lastSwap = j > lastSwap ? j : lastSwap;
//		        }
//	        }
//	        if (!swapped) break;
//	    }
	    
	    while (n != 0) {
	    	lastSwap = 0;
	    	for (int i = 1; i < n; i++) {
	    		num_iter++;
	    		if (a[i] < a[i-1]) {
	    			nSwaps++;
	    			swap(a, i, i-1);
	    			lastSwap = i;
	    		}
	    	}
	    	n = lastSwap;
	    }
	    
	    System.out.println("Num iterations: "+num_iter+" Num Swaps: "+nSwaps);
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
	    
	    System.out.print("Traditional Bubble Sort: ");
	    bubbleSort(array);
	    System.out.print("\t\t\tFinal Output Bubble Sort: ");
	    print(array);
       
	    array = new int[]{7,5,1,2,3,6,4};
	    
	    System.out.print("Optimised Bubble Sort: ");
	    bubbleSortOptimized(array);
	    System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
	    print(array);
	    
	    array = new int[]{7,5,1,2,3,6,4};
	    
	    System.out.print("More Optimised Bubble Sort: ");
	    bubbleSortMoreOptimized(array);
	    System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
	    print(array);
	    System.out.println("**********************************************");
	    
	    array = new int[]{2,3,4,1,5,6,7};
	    System.out.print("\t\t\tUnsorted Array: ");
	    print(array);
	    
	    System.out.print("Traditional Bubble Sort: ");
	    bubbleSort(array);
	    System.out.print("\t\t\tFinal Output Bubble Sort: ");
	    print(array);
       
	    array = new int[]{2,3,4,1,5,6,7};
	    
	    System.out.print("Optimised Bubble Sort: ");
	    bubbleSortOptimized(array);
	    System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
	    print(array);
	    
	    array = new int[]{2,3,4,1,5,6,7};
	    
	    System.out.print("More Optimised Bubble Sort: ");
	    bubbleSortMoreOptimized(array);
	    System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
	    print(array);
	    System.out.println("**********************************************");
	    
	    array = new int[]{1,2,3,4,5,6,7};
	    System.out.print("\t\t\tUnsorted Array: ");
	    print(array);
	    
	    System.out.print("Traditional Bubble Sort: ");
	    bubbleSort(array);
	    System.out.print("\t\t\tFinal Output Bubble Sort: ");
	    print(array);
       
	    array = new int[]{1,2,3,4,5,6,7};
	    
	    System.out.print("Optimised Bubble Sort: ");
	    bubbleSortOptimized(array);
	    System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
	    print(array);
	    
	    array = new int[]{1,2,3,4,5,6,7};
	    array = new int[]{3,1};
	    
	    System.out.print("More Optimised Bubble Sort: ");
	    bubbleSortMoreOptimized(array);
	    System.out.print("\t\t\tFinal Output Optimised Bubble Sort: ");
	    print(array);
    }
}


