public class NqueensAllSolution {
    // print all possible solutions of n queens problem
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        solveNqueensRec(0, board, n);
    }

    public static void solveNqueensRec(int col, int[][] board, int n) {
        if (col >= n) {
            printSolution(board);
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

    private static boolean isSafe(int row, int col, int[][] board,
            int n) {
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

}
