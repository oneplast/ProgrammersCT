import java.io.*;

public class Main {
    static char[] aChars, bChars;
    static int n, m;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        aChars = br.readLine().toCharArray();
        bChars = br.readLine().toCharArray();

        n = aChars.length;
        m = bChars.length;

        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (aChars[i - 1] == bChars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.print(dp[n][m]);
    }
}