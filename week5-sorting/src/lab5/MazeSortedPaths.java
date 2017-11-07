package lab5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Models the complete set of potential paths from a starting point to a goal.
 *  
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 */
public class MazeSortedPaths {
    
    /** 
     * List of paths through the maze, 
     * sorted from shortest (first position) to longest (last position) 
     */
    ArrayList<Path> sortedPaths;

    public MazeSortedPaths(ArrayList<Path> paths) {
        this.sortedPaths = paths;
        sort();
    }

    public ArrayList<Path> getSortedPaths() {
        return sortedPaths;
    }
    
    /** Sorts the list of paths */
    public void sort() {
        /**
         * The sort method in class Collection orders a collection of elements based on the Comparator provided as second argument.
         */ 
        Collections.sort(sortedPaths, (Path p1, Path p2) -> p1.size() - p2.size());
    }
    
    /** Returns the shortest path (one of them if several) */
    public Path getShortestPath() {
        if (sortedPaths != null) {
            return sortedPaths.get(0);
        } else {
            return null;
        }
    }
    
    /** Returns the longest path (one of them if several) */
    public Path getLongestPath() {
        if (sortedPaths != null) {
            return sortedPaths.get(sortedPaths.size() - 1);
        } else {
            return null;
        }
    }

    /** Returns the list of shortest paths (all paths with minimum length) */
    public ArrayList<Path> getShortestPaths() {
        if (sortedPaths == null) {
            return null;
        }

        ArrayList<Path> p = new ArrayList<Path>();
        
        int minLength = sortedPaths.get(0).size();
        int pos;
        for (pos=0; pos<sortedPaths.size() && sortedPaths.get(pos).size() == minLength; pos++) {
            // traverse while paths have minimum length
        	p.add(sortedPaths.get(pos));
        }

        return p;
    }
    
    /** Returns the list of longest paths (all paths with maximum length) */
    public ArrayList<Path> getLongestPaths() {
        if (sortedPaths == null) {
            return null;
        }

        ArrayList<Path> p = new ArrayList<Path>();
        
        int maxLength = sortedPaths.get(sortedPaths.size()-1).size();
        int pos;
        for (pos=sortedPaths.size()-1; pos>=0 && sortedPaths.get(pos).size() == maxLength; pos--) {
            // Traverse from end backwards while paths have maximum length
        	// Adding elements at the beginning is not efficient, as it forces
        	// shifting already inserted elements.
        	// However, adding elements in order requires traversing the subset twice.
        	p.add(0, sortedPaths.get(pos));        	
        }
        
        return p;
        
    }

    /** Prints paths */
    public void print() {
		int i=0;
		for (Path p : sortedPaths) {
			System.out.println("Path " + i++ + " (length="+p.size()+"): " + p);
		}
    }
}


