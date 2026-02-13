import java.io.*;
import java.util.*;

public class Main {

	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[n] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);

		while (!queue.isEmpty()) {
			n = queue.poll();

			if (n >= 1) {
				if (dp[n] == Integer.MAX_VALUE) {
					continue;
				}

				if (n % 3 == 0 && dp[n / 3] > dp[n] + 1) {
					dp[n / 3] = dp[n] + 1;
					queue.offer(n / 3);
				}

				if (n % 2 == 0 && dp[n / 2] > dp[n] + 1) {
					dp[n / 2] = dp[n] + 1;
					queue.offer(n / 2);
				}

				if (dp[n - 1] > dp[n] + 1) {
					dp[n - 1] = dp[n] + 1;
					queue.offer(--n);
				}
			}
		}

		System.out.println(dp[1]);
	}
}