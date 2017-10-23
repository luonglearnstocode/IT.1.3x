package lab1;

/**
 * Class MazePath represents a path through a maze 
 * composed of a doubly-linked list of MazeSteps (positions)
 * 
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 */
public class Path {

    /** First position in the path */    
    private PathStep first;
    
    /** Last position in the path */    
    private PathStep last;
    
    /**
     * Initializes empty path
     */
    public Path() {
        this.first = null;
        this.last = null;
    }
    
    /**
     * Insert the given coordinates as a new step in the first position of the path
     */
    public void insertFirst(int row, int col) {
        // TO DO (Part 3)
        // Learning concepts:
        // Insert first element in doubly linked list
    	PathStep step = new PathStep(row, col);
    	step.setNext(first);
    	if (first != null) {
    		first.setPrev(step);
    	}
    	first = step;
    	if (last == null) {
    		last = step;
    	}
    }
    
    /**
     * Insert the given coordinates as a new step in the last position of the path
     */
    public void insertLast(int row, int col) {
        // TO DO (Part 3)
        // Learning concepts:
        // Insert last element in doubly linked list
    	PathStep step = new PathStep(row, col);
    	if (last == null) {
    		first = step;
    		last = step;
    	} else {
    		last.setNext(step);
    		step.setPrev(last);
    		last = step;
    	}
    }
    
    /**
     * Returns the coordinates of the first step in the path and removes it from the path. 
     * If the Path is empty, returns null.
     */
    public int[] extractFirst() {
        // TO DO (Part 3)
        // Learning concepts:
        // Extract first element of doubly linked list
    	int[] position = null;
    	if (first != null) {
    		position = new int[]{first.getRow(), first.getCol()};
    		first = first.getNext();
    		if (first == null) {
    			last = null;
    		} else {
    			first.setPrev(null);
    		}
    	}
    	
        return position;
    }
    
    /**
     * Returns the coordinates of the last step in the path and removes it from the path. 
     * If the Path is empty, returns null.
     */
    public int[] extractLast() {

        // TO DO (Part 3)
        // Learning concepts:
        // Extract last element of doubly linked list
    	int[] position = null;
    	
    	if (last != null) {
    		position = new int[]{last.getRow(), last.getCol()};
    		
    		if (first == last) { // path of 1 step
    			first = null;
    			last = null;
    		} else {
    			last = last.getPrev();
    			last.setNext(null);
    		}
    	}
    	
        return position;    // TO DO: modify as appropriate
    }
    
    /**
     * Returns a String based representation of the Path.
     * If the Path is empty, returns an empty String ("")
     * If the Path is not empty, returns an String with the format:
     * (row1, col1), (row2, col2), ..., (rowN, colN)
     */
    public String toString() {
        
        String sPath = "";
        
        // TO DO (Part 3)
        // Traverse a linked list concatenating the coordinates of each step. 
        // Recommendation: use the toString method in the PathStep class to get the 
        // "(row, col)" String corresponding to the pair of coordinates of each step.
        
        // Learning concepts:
        // traverse a linked list
        // Important: the Path must not be modified by the method!
        PathStep current = first;
        sPath += current.toString();
        
        while (current.getNext() != null) {
        	sPath += ", " + current.getNext().toString();
        	current = current.getNext();
        }
        
        return sPath;
    }
    

}

