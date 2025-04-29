public class NQueensBranchAndBound {

    static int N;

    public static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void solveNQueens() {
        int[][] board = new int[N][N];

        boolean[] rowOccupied = new boolean[N];
        boolean[] lowerDiagonalOccupied = new boolean[2 * N - 1];  // row + col
        boolean[] upperDiagonalOccupied = new boolean[2 * N - 1];  // (n-1) + (col - row)

        solve(board, 0, rowOccupied, lowerDiagonalOccupied, upperDiagonalOccupied);
    }

    public static void solve(int[][] board, int col, boolean[] rowOccupied, boolean	[] lowerDiagonalOccupied, boolean[] upperDiagonalOccupied) {
        if (col >= N) {
            printSolution(board);
            return;
        }

        for (int row = 0; row < N; row++) {
            if (!rowOccupied[row] && !lowerDiagonalOccupied[row + col] && !upperDiagonalOccupied[N - 1 + col - row]) {
                // Place the queen
                board[row][col] = 1;
                rowOccupied[row] = true;
                lowerDiagonalOccupied[row + col] = true;
                upperDiagonalOccupied[N - 1 + col - row] = true;

                // Recur to place rest
                solve(board, col + 1, rowOccupied, lowerDiagonalOccupied, upperDiagonalOccupied);

                // Backtrack
                board[row][col] = 0;
                rowOccupied[row] = false;
                lowerDiagonalOccupied[row + col] = false;
                upperDiagonalOccupied[N - 1 + col - row] = false;
            }
        }
    }

    public static void main(String[] args) {
        N = 4;  // You can change N to any size
        solveNQueens();
    }
}

