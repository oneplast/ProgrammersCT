import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1_100;
    static final int INF = 1_000_000_000;
    static int c, n;
    static List<int[]> list;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        c = parse(token);
        n = parse(token);
        
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            int cost = parse(token);
            int customer = parse(token);
            list.add(new int[]{cost, customer});
        }
        
        dp = new int[MAX + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int[] city : list) {
            int cost = city[0];
            int customer = city[1];
            for (int i = customer; i <= MAX; i++) {
                dp[i] = Math.min(dp[i], dp[i - customer] + cost);
            }
        }
        
        int result = INF;
        for (int i = c; i <= MAX; i++) {
            result = Math.min(result, dp[i]);
        }
        
        System.out.print(result);
    }
    
    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}