package lab4;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * Class QueuePathFinder implements an algorithm for finding a path using a Queue
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 *
 */
public class QueuePathFinder implements PathFinder {

    /*
     * ** IMPORTANT: 
     * The exploration order determines the path found
     * even forcing to traverse every cell in the maze. 
     * The algorithm takes profit of knowing the start position to be top-left
     * and the goal towards bottom-right.
     * Notice that using a Queue means retrieving elements in the same order they were inserted.
     * Thus, most promising directions are inserted first in the Queue  
     * in order to get them explored first.
     */
    private static final Movement[] DIRS_TO_EXPLORE = new Movement[] {
        	Movement.DOWN,
        	Movement.RIGHT,
        	Movement.LEFT, 
        	Movement.UP 
    };

	public Path findPath(Maze maze) {

		final MazePosition initPos = new MazePosition(0, 0, null);

		Queue<MazePosition> posToExplore = new ArrayDeque<MazePosition>();
		
		MazePosition pos = initPos;
		MazePosition next;
		
		// check initial pos is valid
		
		posToExplore.add(pos);
		
		while (!posToExplore.isEmpty()) {
			pos = posToExplore.remove();

			switch( maze.getPosStatus(pos) ) {

			case GOAL:
				// target found: build path and finish
				Path path = new Path();
				
				
				MazePosition p = pos;
				while (p != null) {
					/* 
					 * Notice that cells must be reversed when building the path 
					 * as we are traversing backwards from the goal towards the initial position
					 */
					path.insertFirst(p.getCoords()[0], p.getCoords()[1]);
					p = p.getFrom();
				}
				
				return path;
				//break;

			case OPEN: 

				maze.setPosStatus(pos, MazeStatus.VISITED);	// mark position as visited

				// get adjacent cells to explore
				/*
				 * ** IMPORTANT: The exploration order determines the path found
				 * even forcing to traverse every cell in the maze 
				 */
				for (Movement mov : DIRS_TO_EXPLORE) {
					next = maze.getNeighbour(pos, mov);
					if (next != null && (maze.getPosStatus(next) == MazeStatus.OPEN || maze.getPosStatus(next) == MazeStatus.GOAL)) {
						// optimization: check if neighbour is already included in the list to explore
						if (!posToExplore.contains(next)) {
							posToExplore.add(next);
						}
					}
				}	

				break;

			case VISITED:
			    // No position is inserted into queue after visited
			    // and a given position cannot change its status
			    // AFTER being inserted 
			    // (because of the FIFO policy and prior checking of repetitions)
			    // This case must be an error

			case OBSTACLE:
				// error: should not be in the list of positions to explore
				return null;
				//break;
			}
		
			
		}
		
		return null;
	}

}
