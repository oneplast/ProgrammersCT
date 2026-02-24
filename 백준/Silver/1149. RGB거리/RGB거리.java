import java.io.*;
import java.util.*;

// 2 <= N <= 1,000
// 1 <= r,g,b <= 1,000
// 1 != 2
// N != N - 1
// i != i - 1 && i != i + 1

public class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[3];

        StringTokenizer token;
        int r, g, b;
        int newR, newG, newB;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            r = parse(token);
            g = parse(token);
            b = parse(token);

            if (i == 0) {
                dp[0] = r;
                dp[1] = g;
                dp[2] = b;
            } else {
                newR = Math.min(dp[1], dp[2]) + r;
                newG = Math.min(dp[0], dp[2]) + g;
                newB = Math.min(dp[0], dp[1]) + b;

                dp[0] = newR;
                dp[1] = newG;
                dp[2] = newB;
            }
        }

        System.out.println(Math.min(dp[0], Math.min(dp[1], dp[2])));
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}