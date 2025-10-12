class Solution {

    int n;
    int m;
    int[][] dp;

    public int solution(int[][] board, int[][] skill) {
        n = board.length;
        m = board[0].length;
        dp = new int[n + 1][m + 1];

        fillDp(skill);
        sumDp();

        return n * m - getDestroyCnt(board);
    }

    private void fillDp(int[][] skill) {
        for (int[] ints : skill) {
            int type = ints[0];
            int r1 = ints[1];
            int c1 = ints[2];
            int r2 = ints[3];
            int c2 = ints[4];
            int degree = ints[5];

            if (type == 1) {
                degree = -degree;
            }

            dp[r1][c1] += degree;
            if (c2 + 1 <= m) {
                dp[r1][c2 + 1] -= degree;
            }
            if (r2 + 1 <= n) {
                dp[r2 + 1][c1] -= degree;
            }
            if (r2 + 1 <= n && c2 + 1 <= m) {
                dp[r2 + 1][c2 + 1] += degree;
            }
        }
    }

    private void sumDp() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    dp[i][j] -= dp[i - 1][j - 1];
                }
            }
        }
    }

    private int getDestroyCnt(int[][] board) {
        int destroyCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += dp[i][j];
                if (board[i][j] < 1) {
                    ++destroyCnt;
                }
            }
        }

        return destroyCnt;
    }
}
