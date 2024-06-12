import java.util.Scanner;

/*
input:
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4 
0 0 5 2 0 6 3 0 0 
*/

/*
Solution:
3 1 6 5 7 8 4 9 2 
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9
*/

public class sudoku {
    static int N = 9;// 9x9 grid

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scan.nextInt();
            }
        }
        scan.close();
        if (solveSudoku(grid, 0, 0)) {
            printSolution(grid);
        } else {
            System.out.println("No Solution exists");
        }

    }

    public static void printSolution(int[][] grid) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean solveSudoku(int[][] grid, int row, int col) {
        // reached 8th row and 9th col ?
        if (row == N - 1 && col == N) {
            return true;
        }

        // go till end of row and if greater than 9 next row and col from 0
        if (col == N) {
            row++;
            col = 0;
        }

        // checks only where elelment is zero and if not goes to next
        if (grid[row][col] != 0) {
            return solveSudoku(grid, row, col + 1);
        }

        // actual number filler
        // run from 1 to 9 and check if it is safe (see is safe function)
        for (int ans = 1; ans < 10; ans++) {
            if (isSafe(grid, row, col, ans)) {
                grid[row][col] = ans;

                // route - till the end of row
                if (solveSudoku(grid, row, col + 1)) {
                    return true;
                }
                // backtracking - removing assumptions if were wrong and go to next
                grid[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int grid[][], int row, int col, int ans) {

        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == ans) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == ans) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + startRow][j + startCol] == ans) {
                    return false;
                }
            }
        }

        return true;
    }
}
