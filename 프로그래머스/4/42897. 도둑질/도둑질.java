class Solution {
    
    int n;

    public int solution(int[] money) {
        n = money.length;

        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        solve(money, dp1, 2, n - 1);

        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];
        solve(money, dp2, 2, n);

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }

    private void solve(int[] money, int[] dp, int start, int end) {
        for (int i = start; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
    }
}