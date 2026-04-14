import java.io.*;

public class Main {
    static int n;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        if (n % 2 == 1) {
            System.out.print(0);
            return;
        }
        
        dp = new int[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = 4 * dp[i - 2] - dp[i - 4];
        }
        
        System.out.print(dp[n]);
    }
}