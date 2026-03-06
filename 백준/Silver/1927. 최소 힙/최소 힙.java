import java.io.*;
import java.util.*;

public class Main {
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a.compareTo(b));
        int x;
        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());
            
            if (x > 0) {
                pq.offer(x);
            } else {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}