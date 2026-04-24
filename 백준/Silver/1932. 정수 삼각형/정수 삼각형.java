import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][];

        StringTokenizer token = new StringTokenizer(br.readLine());
        dp[0] = new int[]{parse(token)};
        for (int i = 1; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            dp[i] = new int[i + 1];

            int data;
            for (int j = 0; j <= i; j++) {
                data = parse(token);
                dp[i][j] = data;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j] + dp[i][j], dp[i + 1][j + 1] + dp[i][j]);
            }
        }

        System.out.print(dp[0][0]);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}