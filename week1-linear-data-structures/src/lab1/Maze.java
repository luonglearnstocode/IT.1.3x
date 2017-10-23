package lab1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Class Maze represents a bidimensional maze 
 * to traverse and find a path through
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 */
public class Maze {

	private MazeStatus[][] maze;
	
	/**
     * Creates an square Maze of given size
     */
	public Maze(int size) {
		this(size, size);
	}
	
    /**
     * Creates a bidimensional Maze of given height and size,
     * with all positions initially open
     */
	public Maze(int width, int height) {
    	// TO DO (Part 1)
	    // Learning concepts to work on:
	    // Create, initialize and traverse a bidimensional array
		this.maze = new MazeStatus[height][width];
		for (MazeStatus[] row : this.maze) {
			Arrays.fill(row, MazeStatus.OPEN);
		}
	}

    /**
     * Initializes a Maze from the given textual representation
     */
	public Maze(String sMaze) {
		this.maze = stringToMaze(sMaze);
	}

	
    /**
     * Returns the MazeStatus value corresponding to the given cell, 
     * specified by its row and column
     */
	public MazeStatus getPosStatus(int row, int col) {
		// TO DO (Part 1)
		// Learning concepts to work on:
		// accessing an array position by its index
		
		return this.maze[row][col];
	}
	
    /**
     * Sets the cell corresponding to the specified row and column to 
     * the given status value
     */
	public void setPosStatus(int row, int col, MazeStatus newStatus) {
		// TO DO (Part 1)
		// Learning concepts to work on:
		// changing the value of an array position given by its index
		this.maze[row][col] = newStatus;
	}
	
    /**
     * Creates and returns an String with 
     * the text-based representation of the given Maze
     */
	public String toString() {
		String s = "";

		// TO DO (Part 1)
		// Learning concepts to work on:
		// traversing an array
		// String concatenation
		for (int i = 0; i < this.maze.length; i++) {
			for (int j = 0; j < this.maze[i].length; j++) {
				s += this.maze[i][j].text();
			}
			s += "\n";
		}
		return s;
	}

    /**
     * Transforms a text-based Maze into a bidimensional array 
     * of positions with the corresponding status.
     * It creates the array maze and assign to each of its cells
     * the corresponding status value based on the given text representation.
     */
	private MazeStatus[][] stringToMaze(String sMaze) {

		/*
		 * Recommendations:
		 * 
		 * Method split in class String can be useful for dividing 
		 * the given String into a set of lines (one per row)
		 *
		 * Method toCharArray in class String can also be useful for 
		 * transforming each line into an array of chars, one per cell
		 *
		 * Use the MazeStatus enumeration type for 
		 * first checking the character corresponding to the cell status, 
		 * and next assigning the corresponding status to the array cell
		 */
	
		// TO DO (Part 1)
		// Learning concepts to work on:
		// array creation, initialization and traversing
		
		String[] lines = sMaze.split("\n");
		MazeStatus[][] maze = new MazeStatus[lines.length][lines[0].length()]; 
		
		Map<Character, MazeStatus> map = new HashMap<>();
		for (MazeStatus mazeStatus : MazeStatus.values()) {
			map.put(mazeStatus.text(), mazeStatus);
		}
		
		for (int i = 0; i < lines.length; i++) {
			char[] chars = lines[i].toCharArray();
			for (int j = 0; j < chars.length; j++) {
				maze[i][j] = MazeStatus.valueOf(map.get(chars[j]) + "");
			}
		}
	
		return maze; // TO DO (Part 1): change appropriately
		
	}
	

    /**
     * Calculates the destination position in the Maze
     * given an starting position (row, col) and  a Movement (mov)
     * 
     * @returns the coordinates of the next position, if its is a valid position. 
     * Returns null if the destination position is outside the limits of the array.
     */
	public int[] getNeighbourCoords(int row, int col, Movement mov) {
		// TO DO (Part 2)
		// Learning concepts to work on:
		// array creation, initialization and limits checking

		return null; // TO DO: change appropriately
	}
	

    /**
     * Changes the state of the maze positions following the given path.
     * If the initial status of the position to visit is OPEN or VISITED 
     * (can step into the position), change it to VISITED.
     * If the initial status of the position to visit is GOAL, does not 
     * change it so that the goal keeps displaying in the maze. 
     * If the initial status of the position to visit is OBSTACLE or 
     * the position is outside the limits of the Maze, it is an invalid move,
     * stop and finish. 
     * Empties the received path as it traverses it.
     * 
     */
    public void followPath(Path path) {
        
		// TO DO (Part 4)
		// Learning concepts to work on:
		// extracting elements from list, accessing and modifying array positions

    }

}

