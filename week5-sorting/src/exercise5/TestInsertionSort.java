package exercise5;

public class TestInsertionSort{
    
    public static void insertionSort(int[] a){
	    int nSwaps=0;
	    int nIter=0;
	    int nPass=0;
	    for (int i=1; i<a.length; i++){
	        nPass++;
	        int tmp=a[i];
	        int j=i;
	        while ((j>0) && (tmp<a[j-1])){
		        nIter++;
		        a[j]=a[j-1];
		        j--;
		        nSwaps++;
	        } 
	        a[j]=tmp;
	    }
	    System.out.println("nPass = "+nPass+
		            	   " nIter: "+nIter+
			               " nSwaps "+nSwaps);
    }
    
    public static void insertionSortAlternative(int[] a){
    	int n = a.length;
    	for (int i = n - 1; i > 0; i--) {
    		int tmp = a[i-1];
    		int j = i - 1;
    		while (j < n-1 && a[j+1] < tmp) {
    			a[j] = a[j+1];
    			j++;
    		}
    		a[j]= tmp;
    	}
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
    	array = new int[]{7, 3};
        System.out.print("Unsorted Array: ");
	    print(array);
	
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println("Insertion Sort: ");
	    insertionSort(array);
    	print(array);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        array = new int[]{2,3,4,5,1};
        System.out.print("Unsorted Array: ");
        print(array);
        System.out.println("Insertion Sort: ");
	    insertionSort(array);
	    print(array);
	
	    System.out.println("**********************************************");
    	array = new int[]{7,5,1,2,3,6,4};
//    	array = new int[]{7, 3};
        System.out.print("Unsorted Array: ");
	    print(array);
	
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
	    System.out.println("Insertion Sort Alternative Version: ");
	    insertionSortAlternative(array);
    	print(array);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        array = new int[]{2,3,4,5,1};
        System.out.print("Unsorted Array: ");
        print(array);
        System.out.println("Insertion Sort Alternative Version: ");
	    insertionSortAlternative(array);
	    print(array);
	
    }
}


