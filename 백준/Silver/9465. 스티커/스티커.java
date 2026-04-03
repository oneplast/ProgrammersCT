import java.io.*;
import java.util.*;

public class Main {
    static int t, n;
    static int[][] arr, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n];
            dp = new int[2][n];
            for (int r = 0; r < 2; r++) {
                token = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[r][j] = parse(token);
                }
            }
            
            if (n == 1) {
                System.out.println(max(arr[0][0], arr[1][0]));
                continue;
            }
            
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = arr[0][1] + arr[1][0];
            dp[1][1] = arr[0][0] + arr[1][1];
            for (int d = 2; d < n; d++) {
                dp[0][d] = max(dp[1][d - 1], max(dp[0][d - 2], dp[1][d - 2])) + arr[0][d];
                dp[1][d] = max(dp[0][d - 1], max(dp[1][d - 2], dp[0][d - 2])) + arr[1][d];
            }
            
            System.out.println(max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
    
    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
    
    private static int max(int a, int b) {
        return Math.max(a, b);
    }
}