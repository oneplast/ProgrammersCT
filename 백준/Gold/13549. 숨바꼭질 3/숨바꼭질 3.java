import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static final int MAX = 100000;
    static int n, k;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        k = parse(token);

        dist = new int[MAX + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{n, 0});
        dist[n] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int time = cur[1];

            if (x == k) {
                System.out.print(time);
                return;
            }

            if (dist[x] < time) {
                continue;
            }

            if (x * 2 <= MAX && dist[x * 2] > time) {
                dist[x * 2] = time;
                pq.offer(new int[]{x * 2, time});
            }

            if (x - 1 >= 0 && dist[x - 1] > time + 1) {
                dist[x - 1] = time + 1;
                pq.offer(new int[]{x - 1, time + 1});
            }

            if (x + 1 <= MAX && dist[x + 1] > time + 1) {
                dist[x + 1] = time + 1;
                pq.offer(new int[]{x + 1, time + 1});
            }
        }
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}