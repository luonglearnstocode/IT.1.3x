package lab3;

/**
 * Main class of the Java program.
 */
public class Main {
    
    
	public static void main(String[] args) {
		
		// Test QueuePathFinder
		QueuePathFinder pf = new QueuePathFinder();

		System.out.println("Test StackPathFinder");
		Maze maze;
		Path path;

		maze = new Maze(MazeSamples.sMaze2);
		path = pf.findPath(maze);
		System.out.println(maze.toString());
		System.out.println(path.toString());

		maze = new Maze(MazeSamples.sMaze3);
		path = pf.findPath(maze);
		System.out.println(maze.toString());
		System.out.println(path.toString());

		maze = new Maze(MazeSamples.sMaze4);
		path = pf.findPath(maze);
		System.out.println(maze.toString());
		System.out.println(path.toString());
	}

}
