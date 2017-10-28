package lab3;

import java.util.ArrayDeque;
import java.util.Queue;

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

        /*
         * // TO DO
         * 
         * Create empty Queue to store maze positions for future visit.
         * You can use the java.util.Queue interface 
         * and one of its implementations (e.g. ArrayDeque) 
         * in the Java API for convenience.
         * 
         * Start at position (0, 0)
         *
         * While there is any position yet to be explored in the Queue :
         *      * check the status of the position
         *      * if GOAL: objective found, build path and finish. 
         *            MazePosition objects include a reference to previous position from which they were reached, 
         *            which is useful for building the path
         *      * if VISITED: 
         *			  No position is inserted into queue after visited
		 *	          and a given position cannot change its status
		 *	          AFTER being inserted 
		 *	          (because of the FIFO policy and prior checking of repetitions)
		 *	          => This case must be an error
         *      * if OBSTACLE: must be an error => return null
         *      * if OPEN:
         *          * change position status to VISITED
         *          * get adjacent positions to explore in the future; 
         *            insert into queue only the ones to be explored (i.e. OPEN or GOAL, ignore VISIED or OBSTACLE)
         *            and that are not included in the queue yet.
         *            Notice that the exploration order determines the path found; 
         *            you are suggested to get neighbours in the order defined in DIRS_TO_EXPLORE
         *
         */
		Queue<MazePosition> queue = new ArrayDeque<>();
		MazePosition current = new MazePosition(0, 0);
		queue.add(current);
		
        while (!queue.isEmpty()) {
        	current = queue.poll();
        	MazeStatus currentStatus = maze.getPosStatus(current);
        	if (currentStatus == MazeStatus.GOAL) {
        		break;
        	} else if (currentStatus == MazeStatus.VISITED) {
        		continue;
        	} else if (currentStatus == MazeStatus.OBSTACLE) {
        		return null;
        	} else if (currentStatus == MazeStatus.OPEN) {
        		maze.setPosStatus(current, MazeStatus.VISITED);
        		MazePosition next;
        		for (Movement mov : DIRS_TO_EXPLORE) {
        			next = maze.getNeighbour(current, mov);
        			if (next != null && 
        					(maze.getPosStatus(next) == MazeStatus.OPEN || maze.getPosStatus(next) == MazeStatus.GOAL)) {
        				queue.add(next);
        			}
        		}
        	}
        }
        
        // build the path
        Path path = new Path();
        int count = 0;
        while (current != null) {
        	count++;
        	int[] coords = current.getCoords();
        	path.insertFirst(coords[0], coords[1]);
        	current = current.getFrom();
        }
        System.out.println("Path of length " + count);
		return path;
	}

}

