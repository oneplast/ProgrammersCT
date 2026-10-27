import java.util.*;

class Solution {
	private static final int LIMIT = 1_000_000;

	public int solution(int x, int y, int n) {
		int[] dp = new int[LIMIT + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[x] = 0;
		for (int i = x; i <= LIMIT; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				continue;
			}

			if (i + n <= LIMIT) {
				dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
			}

			if (i * 2 <= LIMIT) {
				dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
			}

			if (i * 3 <= LIMIT) {
				dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
			}
		}

		return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
	}
}