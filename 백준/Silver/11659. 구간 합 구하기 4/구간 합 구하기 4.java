import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        m = parse(token);
        
        arr = new int[n + 1];
        dp = new int[n + 1];
        token = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = parse(token);
        }
        
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            dp[i] = sum;
        }
        
        int start, end;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            start = parse(token);
            end = parse(token);
            
            sb.append(dp[end] - dp[start - 1]).append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}