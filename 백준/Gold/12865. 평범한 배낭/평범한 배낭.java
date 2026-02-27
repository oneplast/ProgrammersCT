import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        k = parse(token);
        dp = new int[n + 1][k + 1];

        int w, v;
        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(br.readLine());
            w = parse(token);
            v = parse(token);

            System.arraycopy(dp[i - 1], 0, dp[i], 0, k + 1);

            for (int j = w; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
            }
        }

        int result = Arrays.stream(dp[n])
                .max().getAsInt();

        System.out.println(result);
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}