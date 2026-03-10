import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] matrix;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = parse(token);
        m = parse(token);

        matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = parse(token);
            }
        }

        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }

        int x1, x2, y1, y2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            x1 = parse(token);
            y1 = parse(token);
            x2 = parse(token);
            y2 = parse(token);

            sb.append(dp[x2][y2] - (dp[x1 - 1][y2] + dp[x2][y1 - 1] - dp[x1 - 1][y1 - 1])).append("\n");
        }

        System.out.print(sb);
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}