import java.util.*;
import java.io.*;

public class Main {
    static int[] nArr;
    static int[] minDp;
    static int[] maxDp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int n = parse(token);
        int m = parse(token);
        
        nArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nArr[i] = Integer.parseInt(br.readLine());
        }
        
        minDp = new int[4 * n];
        maxDp = new int[4 * n];
        memo(1, 1, n);
        
        StringBuilder sb = new StringBuilder();
        int a, b;
        int[] results;
        for (int i = 0; i< m; i++) {
            token = new StringTokenizer(br.readLine());
            a = parse(token);
            b = parse(token);
            
            results = getResults(1, 1, n, a, b);
            sb.append(results[0]).append(" ").append(results[1]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void memo(int idx, int left, int right) {
        if (left == right) {
            minDp[idx] = maxDp[idx] = nArr[left];
            return;
        }
        
        int mid = (left + right) / 2;
        memo(idx * 2, left, mid);
        memo(idx * 2 + 1, mid + 1, right);
        minDp[idx] = Math.min(minDp[idx * 2], minDp[idx * 2 + 1]);
        maxDp[idx] = Math.max(maxDp[idx * 2], maxDp[idx * 2 + 1]);
    }
    
    public static int[] getResults(int idx, int left, int right, int a, int b) {
        if (a > right || b < left) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        
        if (a <= left && b >= right) {
            return new int[]{minDp[idx], maxDp[idx]};
        }
        
        int mid = (left + right) / 2;
        int[] divLeft = getResults(idx * 2, left, mid, a, b);
        int[] divRight = getResults(idx * 2 + 1, mid + 1, right, a, b);
        
        return new int[]{Math.min(divLeft[0], divRight[0]), Math.max(divLeft[1], divRight[1])};
    }
    
    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}