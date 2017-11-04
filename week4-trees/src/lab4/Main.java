package lab4;

import java.util.ArrayList;

/**
 * Main class of the Java program.
 */
public class Main {
    
    
	public static void main(String[] args) {
		
		// Test PathsTree
		System.out.println("========== Test PathsTree ==========");
		Maze maze;
		PathsTree tree;
		ArrayList<Path> paths;
		int i;

		System.out.println();
		System.out.println("----- Test PathsTree [maze sample 5] ---------- ");
		maze = new Maze(MazeSamples.sMaze5);
		tree = new PathsTree(maze);
		//tree.buildPathsTree();
		System.out.println(maze.toString());
		tree.print();
		System.out.println("Test PathsTree [maze sample 5]: findAllPaths ");
		paths = tree.findAllPaths();
		i=0;
		for (Path p : paths) {
			System.out.println("Path " + i++ + ": " + p);
		}

		System.out.println();
		System.out.println("----- Test PathsTree [maze sample 6] ---------- ");
		maze = new Maze(MazeSamples.sMaze6);
		tree = new PathsTree(maze);
		//tree.buildPathsTree();
		System.out.println(maze.toString());
		tree.print();
		System.out.println("Test PathsTree [maze sample 6]: findAllPaths ");
		paths = tree.findAllPaths();
		i=0;
		for (Path p : paths) {
			System.out.println("Path " + i++ + ": " + p);
		}

		System.out.println();
		System.out.println("----- Test PathsTree [maze sample 2] ---------- ");
		maze = new Maze(MazeSamples.sMaze2);
		tree = new PathsTree(maze);
		//tree.buildPathsTree();
		System.out.println(maze.toString());
		tree.print();
		System.out.println("Test PathsTree [maze sample 2]: findAllPaths ");
		paths = tree.findAllPaths();
		i=0;
		for (Path p : paths) {
			System.out.println("Path " + i++ + ": " + p);
		}
		
		System.out.println();
		Path path;
		PathFinder pf;
		pf= new QueuePathFinder();
		path = pf.findPath(new Maze(MazeSamples.sMaze2));
		System.out.println("QueuePathFinder solution: " + paths.indexOf(path));
		System.out.println(path.toString());
		pf= new StackPathFinder();
		path = pf.findPath(new Maze(MazeSamples.sMaze2));
		System.out.println("StackPathFinder solution: " + paths.indexOf(path));
		System.out.println(path);
		
		

	}

}


