import java.io.*;
import java.util.*;

public class Main {
    static final int[] envelopes = {3, 5};
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        final int INF = n + 1;

        dp = new int[INF];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int envelope : envelopes) {
                if (i >= envelope) {
                    dp[i] = Math.min(dp[i], dp[i - envelope] + 1);
                }
            }
        }

        System.out.print(dp[n] == INF ? -1 : dp[n]);
    }
}