package lab5;

import java.util.Stack;

/**
 * Class StackPathFinder implements an algorithm for finding a path using a Stack
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 *
 */
public class StackPathFinder implements PathFinder {

    /*
     * ** IMPORTANT: 
     * The exploration order determines the path found
     * even forcing to traverse every cell in the maze. 
     * The algorithm takes profit of knowing the start position to be top-left
     * and the goal towards bottom-right.
     * Notice that using a Stack means retrieving elements in reverse order.
     * Thus, most promising directions are inserted last in the Stack 
     * in order to get them explored first.
     */
    private static final Movement[] DIRS_TO_EXPLORE = new Movement[] {
        	Movement.LEFT, 
        	Movement.UP, 
        	Movement.DOWN,
        	Movement.RIGHT
    };

	public Path findPath(Maze maze) {

		final MazePosition initPos = new MazePosition(0, 0, null);

		Stack<MazePosition> posToExplore = new Stack<MazePosition>();
		
		MazePosition pos = initPos;
		MazePosition next;
		
		// check initial pos is valid
		
		posToExplore.push(pos);
		
		while (!posToExplore.isEmpty()) {
			pos = posToExplore.pop();
			
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
						posToExplore.push(next);
					}
				}	

				break;

			case VISITED:
			    // No position is inserted into stack after visited
			    // but a given position can change its status
			    // AFTER being inserted
			    // It should not need to be revisited but is not an error
			    break;
			case OBSTACLE:
				// error: should not be in the list of positions to explore
				return null;
				//break;
			}
		
			
		}
		
		return null;
	}

}

