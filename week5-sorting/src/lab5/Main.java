package lab5;
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
		MazeSortedPaths sortedPaths;
		ArrayList<Path> sPaths, lPaths;
		int i;

		// ----------------------------------------------
		
		System.out.println();
		System.out.println("----- Test PathsTree [maze sample 5] ---------- ");
		maze = new Maze(MazeSamples.sMaze5);
		tree = new PathsTree(maze);
		System.out.println(maze.toString());
		//tree.print();
		System.out.println("Test PathsTree [maze sample 5]: findAllPaths ");
		paths = tree.findAllPaths();
		i=0;
		for (Path p : paths) {
			System.out.println("Path " + i++ + ": " + p);
		}
		System.out.println("Test MazePaths [maze sample 5]: all paths sorted ");
		sortedPaths = new MazeSortedPaths(paths);
		sortedPaths.print();
		System.out.println("Test MazePaths [maze sample 5]: shortest path");
		System.out.println(sortedPaths.getShortestPath().toString());
		System.out.println("Test MazePaths [maze sample 5]: all shortest paths");
		sPaths = sortedPaths.getShortestPaths();
		i=0;
		for (Path p : sPaths) {
			System.out.println("Path " + i + " (length="+sPaths.get(i).size()+"): " + p);
			i++;
		}
		//System.out.println(sortedPaths.getShortestPaths().toString());
		System.out.println("Test MazePaths [maze sample 5]: longest path");
		System.out.println(sortedPaths.getLongestPath().toString());
		System.out.println("Test MazePaths [maze sample 5]: all longest paths");
		lPaths = sortedPaths.getLongestPaths();
		i=0;
		for (Path p : lPaths) {
			System.out.println("Path " + i + " (length="+lPaths.get(i).size()+"): " + p);
			i++;
		}
		
		// ----------------------------------------------
		
		System.out.println();
		System.out.println("----- Test PathsTree [maze sample 6] ---------- ");
		maze = new Maze(MazeSamples.sMaze6);
		tree = new PathsTree(maze);
		System.out.println(maze.toString());
		//tree.print();
		System.out.println("Test PathsTree [maze sample 6]: findAllPaths ");
		paths = tree.findAllPaths();
		i=0;
		for (Path p : paths) {
			System.out.println("Path " + i++ + ": " + p);
		}
		System.out.println("Test MazePaths [maze sample 6]: all paths sorted ");
		sortedPaths = new MazeSortedPaths(paths);
		sortedPaths.print();
		System.out.println("Test MazePaths [maze sample 6]: shortest path");
		System.out.println(sortedPaths.getShortestPath().toString());
		System.out.println("Test MazePaths [maze sample 6]: all shortest paths");
		sPaths = sortedPaths.getShortestPaths();
		i=0;
		for (Path p : sPaths) {
			System.out.println("Path " + i + " (length="+sPaths.get(i).size()+"): " + p);
			i++;
		}
		//System.out.println(sortedPaths.getShortestPaths().toString());
		System.out.println("Test MazePaths [maze sample 6]: longest path");
		System.out.println(sortedPaths.getLongestPath().toString());
		System.out.println("Test MazePaths [maze sample 6]: all longest paths");
		lPaths = sortedPaths.getLongestPaths();
		i=0;
		for (Path p : lPaths) {
			System.out.println("Path " + i + " (length="+lPaths.get(i).size()+"): " + p);
			i++;
		}
		
		// ----------------------------------------------
		
		System.out.println();
		System.out.println("----- Test PathsTree [maze sample 2] ---------- ");
		maze = new Maze(MazeSamples.sMaze2);
		tree = new PathsTree(maze);
		System.out.println(maze.toString());
		//tree.print();
		System.out.println("Test PathsTree [maze sample 2]: findAllPaths ");
		paths = tree.findAllPaths();
		i=0;
		for (Path p : paths) {
			System.out.println("Path " + i++ + ": " + p);
		}
		System.out.println("Test MazePaths [maze sample 2]: all paths sorted ");
		sortedPaths = new MazeSortedPaths(paths);
		sortedPaths.print();
		System.out.println("Test MazePaths [maze sample 2]: shortest path");
		System.out.println(sortedPaths.getShortestPath().toString());
		System.out.println("Test MazePaths [maze sample 2]: all shortest paths");
		sPaths = sortedPaths.getShortestPaths();
		i=0;
		for (Path p : sPaths) {
			System.out.println("Path " + i + " (length="+sPaths.get(i).size()+"): " + p);
			i++;
		}
		//System.out.println(sortedPaths.getShortestPaths().toString());
		System.out.println("Test MazePaths [maze sample 2]: longest path");
		System.out.println(sortedPaths.getLongestPath().toString());
		System.out.println("Test MazePaths [maze sample 2]: all longest paths");
		lPaths = sortedPaths.getLongestPaths();
		i=0;
		for (Path p : lPaths) {
			System.out.println("Path " + i + " (length="+lPaths.get(i).size()+"): " + p);
			i++;
		}
		

	}

}



