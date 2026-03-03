import java.util.*;
import java.io.*;

public class Main {
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        long x;
        for (int i = 0; i < n; i++) {
            x = Long.parseLong(br.readLine());
            
            if (x > 0) {
                pq.offer(x);
            } else {
                if (pq.isEmpty()) {
                    sb.append(x);
                } else {
                    sb.append(pq.poll());
                }
                
                sb.append("\n");
            }
        }
        
        System.out.println(sb);
    }
}