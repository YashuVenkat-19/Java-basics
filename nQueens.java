public class nQueens {
    public static void main(String[] args) {
        int n = 4; // n is the number of queens to place on the board
        int[][] board = new int[n][n]; // the board is represented as an array of integers
        // queen on the board
        if (solveNqueensRec(0, board, n) == false) {
            System.out.println("Solution does not exist");
        } else {
            printSolution(board);
        }
    }

    public static boolean solveNqueensRec(int col, int[][] board, int n) {
        // if all queens are placed, then true -> done
        if (col >= n) {
            return true;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 1;
                if (solveNqueensRec(col + 1, board, n)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int row, int col, int[][] board, int n) {
        // upper diagonal
        // left row
        // lower diagonal

        int r = row;
        int c = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }

        row = r;
        col = c;

        while (col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            col--;
        }

        col = c;

        while (row < n && col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    public static void printSolution(int[][] board) {
        for (int i = 0; i < board.length; i++) { // for each row in the board
            for (int j = 0; j < board.length; j++) { // for each column in the row
                if (board[i][j] == 1) { // if the current position is occupied by a queen
                    System.out.print("Q "); // print "Q" to represent the queen
                } else {
                    System.out.print("* "); // print "*" to represent an empty cell
                }
            }
            System.out.println(); // print a newline to separate rows
        }
        System.out.println(); // print a newline to separate solutions
    }
}