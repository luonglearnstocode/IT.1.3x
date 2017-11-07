package lab5;

import java.util.ArrayList;

/**
 * Models the complete set of potential paths from a starting point. 
 * Notice that it grows exponentially,
 * and thus may surpass space/time limits pretty soon.
 *  
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 */
public class PathsTree {
	
	private PathsTreeNode root;
	
	/**
	 * Initializes an empty tree
	 */
	public PathsTree() {
		this.root = null;
	}

	/**
	 * Initializes a tree starting at position (0, 0) of Maze maze 
	 */
	public PathsTree(Maze maze) {
		this.root = new PathsTreeNode(maze, new MazePosition(0, 0, null));
	}
	
	/**
	 * Initializes a tree with root at position pos of Maze maze
	 */
	public PathsTree(Maze maze, MazePosition pos) {
		this.root = new PathsTreeNode(maze, pos);
	}

	public void print() {
		print(0);
	}
	
	private void print(int indent) {
		if (root == null) return;
		for (int i = 0; i < indent; i++) 
			System.out.print(" ");
		
		System.out.println(root.pos);
		for (PathsTree node : root.children) {
			node.print(indent + 2);
		}
	}
	
	public ArrayList<Path> findAllPaths() {
		ArrayList<Path> paths = new ArrayList<Path>();
		return findAllPaths(paths);
	}

	public ArrayList<Path> findAllPaths(ArrayList<Path> paths) {
		if (root != null) {
			if (root.maze.getPosStatus(root.pos) == MazeStatus.GOAL) {
				/* rebuild path */
				Path path = new Path();
				MazePosition current = root.pos;
				while (current != null) {
					path.insertFirst(current.getCoords()[0], current.getCoords()[1]);
					current = current.getFrom();
				}
				paths.add(path);
			} else {
				for (PathsTree node : root.children) {
					node.findAllPaths(paths);
				}
			}
			return paths;
		}
		return paths;
	}


	/**
	 * Models each node in the paths tree
	 * Contains the position of the current step 
	 * and references to the next possible steps
	 */
	private class PathsTreeNode {
		
		private Maze maze;
		private MazePosition pos;
		private ArrayList<PathsTree> children;

		PathsTreeNode(Maze maze, MazePosition pos) {
			this.maze = maze;
			this.pos = pos;
			this.children = new ArrayList<PathsTree>();
			this.stepForward();
		}
		
		void stepForward() {

			if (maze.getPosStatus(pos) != MazeStatus.GOAL) {
				// if GOAL reached, nowhere to go

				MazePosition next;
				for (Movement mov : Movement.values()) {
					next = maze.getNeighbour(pos, mov);
					if ((next != null) 
						&& (maze.getPosStatus(next) == MazeStatus.OPEN || maze.getPosStatus(next) == MazeStatus.GOAL) // valid position
						&& !this.isAncestor(next)) // not already visited in this path 						
					{
						children.add(new PathsTree(maze, next));
					}
				}	
			}
			
		}
		
		/**
		 * Checks whether pos is an ancestor of this
		 */
		boolean isAncestor(MazePosition pos) {
			
			boolean res = false;
			MazePosition p = this.pos;
			while (p != null) {
				if (p.equals(pos)){
					return true;
				}
				p = p.getFrom();
			}
			return res;
			
		}
		
	}

}


