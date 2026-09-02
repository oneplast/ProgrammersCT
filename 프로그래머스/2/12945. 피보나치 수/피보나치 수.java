class Solution {
	static final int MOD = 1_234_567;

	public int solution(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			memo(dp, i);
		}

		return dp[n];
	}

	private void memo(int[] dp, int n) {
		dp[n] = (dp[n - 1] + dp[n - 2]) % MOD;
	}
}