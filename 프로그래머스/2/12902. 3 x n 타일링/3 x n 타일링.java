class Solution {

    long[] dp;
    static final long MOD = 1_000_000_007;

    public int solution(int n) {
        if (n % 2 != 0) {
            return 0;
        }

        dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = (3 * dp[i - 2]) % MOD;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] = (dp[i] + (2 * dp[j])) % MOD;
            }
        }

        return (int) dp[n];
    }
}
