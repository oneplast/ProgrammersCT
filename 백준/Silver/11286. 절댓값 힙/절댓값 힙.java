import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        StringBuilder sb = new StringBuilder();
        int oper;
        for (int i = 0; i < n; i++) {
            oper = Integer.parseInt(br.readLine());
            if (oper != 0) {
                if (oper > 0) {
                    pq.offer(new int[]{oper, 1});
                } else {
                    pq.offer(new int[]{-oper, 0});
                }
            } else {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    int[] cur = pq.poll();
                    sb.append(cur[1] == 1 ? cur[0] : -cur[0]);
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}
