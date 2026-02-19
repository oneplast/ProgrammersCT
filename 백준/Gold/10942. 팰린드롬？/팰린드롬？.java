import java.io.*;
import java.util.*;

// 1 <= n <= 2,000
// 1 <= m <= 1,000,000
// 1 <= s, e <= 2,000

public class Main {
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = parse(token);
        }

        dp = new boolean[n + 1][n + 1];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    dp[i][j] = (nums[i] == nums[j]);
                } else {
                    dp[i][j] = (nums[i] == nums[j]) && dp[i + 1][j - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int s, e;
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            s = parse(token);
            e = parse(token);

            if (isPalindrome(s, e)) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isPalindrome(int s, int e) {
        return dp[s][e];
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}
