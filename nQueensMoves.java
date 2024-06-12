// Sample Input 0
// 4

// Sample Output 0
// The No of Moves :8
// The no of Bactrack Moves:4
// 0 0 1 0 
// 1 0 0 0 
// 0 0 0 1 
// 0 1 0 0 
// Total number of Solutions - 2

public class nQueensMoves {
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        solveNqueensRec(0, board, n);
        System.out.println("The No of Moves :" + solveNqueensRecMoves(0, board, n));
        System.out.println("The no of Backtrack Moves:" + (solveNqueensRecMoves(0, board, n) - 1));
        printBoard(board);
        System.out.print("Total number of Solutions - " + solveNqueensRecMoves(0, board, n) / 2);
    }

    public static void solveNqueensRec(int col, int[][] board, int n) {
        if (col >= n) {
            // printSolution(board);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 1;
                solveNqueensRec(col + 1, board, n);
                board[row][col] = 0;
            }
        }
    }

    public static int solveNqueensRecMoves(int col, int[][] board, int n) {
        if (col >= n) {
            return 1;
        }
        int count = 0;
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 1;
                count += solveNqueensRecMoves(col + 1, board, n);
                board[row][col] = 0;
            }
        }
        return count;
    }

    private static boolean isSafe(int row, int col, int[][] board, int n) {
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
