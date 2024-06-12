import java.util.*;

public class maze2direction {
    static int N = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        N = n;
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = scan.nextInt();
            }
        }
        scan.close();
        solveMaze(maze);
    }

    // to print solution array
    static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    // to check if its in the maze
    static boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1);
    }

    // create solution matrix and search for path and finally print result
    static boolean solveMaze(int maze[][]) {
        int sol[][] = new int[N][N];
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.println("Solution doesn't exist");
            return false;
        }
        System.out.println("Solution:");
        printSolution(sol);
        return true;
    }

    // searching path
    static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            // end of matrix
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y) == true) {
            if (sol[x][y] == 1) {
                // checking if already gone or wrong route
                return false;
            }

            sol[x][y] = 1;// flagged as visited

            // go column-wise to reach end
            if (solveMazeUtil(maze, x + 1, y, sol)) {
                return true;
            }

            // go row-wise to reach end
            if (solveMazeUtil(maze, x, y + 1, sol)) {
                return true;
            }

            // if none of above conditions work BACKTRACK - unmark x,y
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

}
