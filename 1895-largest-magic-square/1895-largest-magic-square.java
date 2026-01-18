class Solution {

    public int largestMagicSquare(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Row-wise prefix sum
        int[][] rowCumsum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            rowCumsum[i][0] = grid[i][0];
            for (int j = 1; j < cols; j++) {
                rowCumsum[i][j] = rowCumsum[i][j - 1] + grid[i][j];
            }
        }

        // Column-wise prefix sum
        int[][] colCumsum = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            colCumsum[0][j] = grid[0][j];
            for (int i = 1; i < rows; i++) {
                colCumsum[i][j] = colCumsum[i - 1][j] + grid[i][j];
            }
        }

        // Try all square sizes from largest to smallest
        for (int side = Math.min(rows, cols); side >= 2; side--) {

            // Fix top-left corner
            for (int i = 0; i + side - 1 < rows; i++) {
                for (int j = 0; j + side - 1 < cols; j++) {

                    // Target sum from first row
                    int targetSum;
                    if (j > 0) {
                        targetSum = rowCumsum[i][j + side - 1] - rowCumsum[i][j - 1];
                    } else {
                        targetSum = rowCumsum[i][j + side - 1];
                    }

                    boolean allSame = true;

                    // Check all rows
                    for (int r = i + 1; r < i + side; r++) {

                        int rowSum;
                        if (j > 0) {
                            rowSum = rowCumsum[r][j + side - 1] - rowCumsum[r][j - 1];
                        } else {
                            rowSum = rowCumsum[r][j + side - 1];
                        }

                        if (rowSum != targetSum) {
                            allSame = false;
                            break;
                        }
                    }

                    if (allSame) {

                        // Check all columns
                        for (int c = j; c < j + side; c++) {

                            int colSum;
                            if (i > 0) {
                                colSum = colCumsum[i + side - 1][c] - colCumsum[i - 1][c];
                            } else {
                                colSum = colCumsum[i + side - 1][c];
                            }

                            if (colSum != targetSum) {
                                allSame = false;
                                break;
                            }
                        }
                    }

                    if (allSame) {

                        // Check diagonals
                        int diag = 0;
                        int antiDiag = 0;

                        for (int k = 0; k < side; k++) {
                            diag += grid[i + k][j + k];
                            antiDiag += grid[i + k][j + side - 1 - k];
                        }

                        if (diag == targetSum && antiDiag == targetSum) {
                            return side;
                        }
                    }
                }
            }
        }

        return 1;
    }
}
