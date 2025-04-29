package abc;

public class NQueensBacktracking {

    static int N;

    // Print the board
    public static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if it's safe to place a queen at board[row][col]
    public static boolean isSafe(int[][] board, int row, int col) {
        // Check left side of row
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower-left diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Solve using Backtracking
    public static boolean solveNQueens(int[][] board, int col) {
        // If all queens are placed, return true
        if (col >= N) {
            printSolution(board);
            return true;
        }

        boolean res = false;
        // Try placing queen in all rows of the current column
        for (int i = 0; i < N; i++) {
            // Check if it's safe to place queen
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place queen

                // Recur to place the next queen in the next column
                res = solveNQueens(board, col + 1) || res;

                // Backtrack: Remove queen (reset the board)
                board[i][col] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        N = 4; // You can change this to 8, etc.
        int[][] board = new int[N][N];
        solveNQueens(board, 0); // Start solving from column 0
    }
}
