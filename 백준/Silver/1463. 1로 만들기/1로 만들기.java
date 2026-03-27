import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        while (n >= 1) {
            if (n >= 3 && n % 3 == 0) {
                dp[n / 3] = Math.min(dp[n / 3], dp[n] + 1);
            }

            if (n >= 2 && n % 2 == 0) {
                dp[n / 2] = Math.min(dp[n / 2], dp[n] + 1);
            }

            dp[n - 1] = Math.min(dp[n - 1], dp[n] + 1);
            n--;
        }

        System.out.print(dp[1]);
    }
}