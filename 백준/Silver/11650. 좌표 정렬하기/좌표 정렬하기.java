import java.util.*;
import java.io.*;

public class Main {
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]);
        });
        int x, y;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            x = parse(token);
            y = parse(token);
            
            pq.offer(new int[]{x, y});
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            sb.append(cur[0]).append(" ").append(cur[1]).append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}