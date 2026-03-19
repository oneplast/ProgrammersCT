import java.io.*;

public class Main {
    static int n;
    static int[] steps;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }
        
        if (n == 1) {
            System.out.print(steps[0]);
            return;
        }
        
        if (n == 2) {
            System.out.print(steps[0] + steps[1]);
            return;
        }
        
        dp = new int[n];
        dp[0] = steps[0];
        dp[1] = steps[0] + steps[1];
        dp[2] = Math.max(steps[0] + steps[2], steps[1] + steps[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + steps[i], dp[i - 3] + steps[i - 1] + steps[i]);
        }
        
        System.out.print(dp[n - 1]);
    }
}