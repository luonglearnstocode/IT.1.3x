package exercise7;

public class TestBubbleSort{
    
    /* This is the algorithm from the video */
    public static void bubbleSort(int[] a){
	    int n=a.length;
	    int num_iter=0;
	    for(int i=0; i<n; i++){
	        System.out.println("Outer: "+i);
	        for(int j=1; j<(n-i); j++){
	            num_iter++;
	            System.out.println("\tInner: "+j);
		        if(a[j-1]>a[j]){
		            swap(a,j-1,j);
		            System.out.print("\t\t[ "+(j-1)+"<->"+j+" ]: ");
		            print(a);
		        }
	        }
	    }
	    System.out.println("Num iterations: "+num_iter);
    }
    
    /* This is a possible solution for the exercise */
    public static void bubbleSortRecursive(int[] a){
        bubbleSortRec(a,a.length);
    }
        
    public static void bubbleSortRec(int[] a, int n){
	   if (n == 1) return;
	   for (int i = 1; i < n; i++) {
		   if (a[i-1] > a[i])
			   swap(a, i-1, i);
	   }
	   bubbleSortRec(a, n-1);
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

	    int array[] = {7,5,1,2,3,6,4};
	    System.out.print("Unsorted Array: ");
	    print(array);
	    
	    bubbleSort(array);
	    System.out.print("Final Output Bubble Sort: ");
	    print(array);
        
	    array = new int[]{7,5,1,2,3,6,4};
	    
	    System.out.print("Unsorted Array: ");
	    print(array);
	    bubbleSortRecursive(array);
	    System.out.print("Final Output Recursive Bubble Sort: ");
	    print(array);
	    
    }
}



