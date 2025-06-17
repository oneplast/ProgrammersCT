class Solution {
    public int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row][col];
        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i % 2][j] = board[i][j];
                if (i != 0 && j != 0 && dp[i % 2][j] != 0) {
                    int left = dp[i % 2][j - 1];
                    int up = dp[(i - 1) % 2][j];
                    int lu = dp[(i - 1) % 2][j - 1];

                    int min = Math.min(left, Math.min(up, lu));
                    dp[i % 2][j] = min + 1;
                }
                max = Math.max(max, dp[i % 2][j]);
            }
        }

        return max * max;
    }
}