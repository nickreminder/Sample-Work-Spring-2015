// Nicholas Reminder
// cs62 ps5, 3-10-15
// nicholas.reminder@pomona.edu

/**
 * solve a maze recursively using backtracking and a stack
 */
import java.util.*;

public class SolveMaze {

    private static boolean debug = true;
    // private static boolean debug = false;

    // Run it as one of the following three:
    //    java Maze 1
    //    java Maze 2
    //    java Maze 3
    //    java Maze 4
    // Note: Try a maze that does not have a way out
    //
    // Maze is represented as a 2D array of int's: 
    //     0 = black space that you can step into
    //     1 = occupied space that you can not step into
    //     2 = path through the maze
    //     9 = visited space that led to a dead-end
    //
    // These example mazes all start at the upper left corner (0, 0) and
    // end at the lower right corner (rowlength-1, columnlength-1).

    public static void main(String[] args) {
        int which = Integer.parseInt(args[0]);
        int[][] maze;
        if (which == 1) {
            System.out.println("\n***** First maze **********");
                int[][] maze1 = {
                    {0,0,0,0,0,0},
                    {1,0,1,0,1,0},
                    {0,1,0,0,0,1},
                    {1,0,1,1,0,1},
                    {0,1,1,0,0,0}
                    };
                maze = maze1;
        }
        else if (which == 2) { // This one does not have a valid entrance
            System.out.println("\n***** Second maze with no way in ********");
                int[][] maze2 = {
                    {1,0,0,0,0,0},
                    {1,0,1,0,1,0},
                    {0,1,0,0,0,1},
                    {1,0,1,1,1,1},
                    {0,1,1,0,0,0}
                    };
                maze = maze2;
        }
        else if (which == 3) { // This one does not have a way out
            System.out.println("\n***** Third maze with no way out ********");
                int[][] maze3 = {
                    {0,0,0,0,0,0},
                    {1,0,1,0,1,0},
                    {0,1,0,0,0,1},
                    {1,0,1,1,1,1},
                    {0,1,1,0,0,0}
                    };
                maze = maze3;
        }
        else {  
            System.out.println("\n***** Fourth maze **********");
                    int[][] maze4 = {
                    {0,1,0,0,0,1,1,0,0,0,1,1,1,1,1},
                    {0,0,0,0,1,1,0,1,1,1,0,0,1,1,1},
                    {0,1,1,0,0,0,0,0,1,1,1,0,0,1,1},
                    {1,1,0,1,1,1,1,0,1,1,0,1,1,0,0},
                    {1,1,0,1,0,0,1,0,1,1,1,1,1,1,1},
                    {0,0,1,1,0,1,1,0,0,1,0,0,1,0,1},
                    {0,1,1,1,1,0,0,1,0,0,0,0,0,0,1},
                    {0,0,1,1,0,1,1,0,1,1,0,1,1,0,1},
                    {1,1,0,0,0,1,1,0,1,1,1,0,0,0,0},
                    {0,0,1,1,1,1,1,0,0,0,1,1,1,1,0},
                    {0,1,0,0,1,1,1,1,1,0,1,1,1,1,0}
                    };
                maze = maze4;
        }
        printArray(maze);
        Stack<String> thePath = new Stack<>();
        boolean successful = false;
        if (maze[0][0] == 0) {
            successful = solveMaze(0, 0, maze.length-1, maze[0].length-1, maze, thePath);
        }
        printArray(maze);
        if (successful) {
            System.out.println("The path for the way out is:\n" + thePath);
        }
        else {
            System.out.println("There was no successful path.");
        }
    }

    // Pre: maze[0][0] = 0;    
    public static boolean solveMaze(int ihere, int jhere,
                                    int igoal, int jgoal,
                                    int[][] maze, Stack<String> path) {
        if (debug) {
            System.out.println("Moved into: " + ihere + ", " + jhere);
        }

        // TODO complete this recursive method
        maze[ihere][jhere] = 2;
        
        if (jhere == jgoal && ihere == igoal) return true;
        
        else {
        	if (jhere != jgoal && maze[ihere][jhere+1] == 0) {
        		path.push("E");
        		if (solveMaze(ihere, jhere+1, igoal, jgoal, maze, path)) return true;
        		else {
        			path.pop();
        			maze[ihere][jhere+1] = 9;
        		}
        	}
        	if (ihere != 0 && maze[ihere-1][jhere] == 0) {
        		path.push("N");
        		if (solveMaze(ihere-1, jhere, igoal, jgoal, maze, path)) return true;
        		else {
        			path.pop();
        			maze[ihere-1][jhere] = 9;
        		}
        	}
        	if (jhere != 0 && maze[ihere][jhere-1] == 0) {
        		path.push("W");
        		if (solveMaze(ihere, jhere-1, igoal, jgoal, maze, path)) return true;
        		else {
        			path.pop();
        			maze[ihere][jhere-1] = 9;
        		}
        	}
        	if (ihere != igoal && maze[ihere+1][jhere] == 0) {
        		path.push("S");
        		if (solveMaze(ihere+1, jhere, igoal, jgoal, maze, path)) return true;
        		else {
        			path.pop();
        			maze[ihere+1][jhere] = 9;
        		}
        	}      		
        }

        if (debug) {
            System.out.println("Backing out of: " + ihere + ", " + jhere);
        }
        
        return false;           // out and try to continue
    }

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

}

