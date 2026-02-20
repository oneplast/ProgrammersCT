import java.io.*;
import java.util.*;

// 1 <= V (n) <= 20,000
// 1 <= E <= 300,000
// 1 <= K <= 20,000

public class Main {
    static List<int[]>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = parse(token);
        int e = parse(token);
        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int u, v, w;
        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine());
            u = parse(token);
            v = parse(token);
            w = parse(token);

            graph[u].add(new int[]{v, w});
        }

        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra(int k) {
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int to = cur[0];
            int weight = cur[1];

            if (dist[to] < weight) {
                continue;
            }

            for (int[] adjArr : graph[to]) {
                int adjTo = adjArr[0];
                int adjWeight = adjArr[1];

                if (dist[adjTo] > weight + adjWeight) {
                    dist[adjTo] = weight + adjWeight;
                    pq.offer(new int[]{adjTo, dist[adjTo]});
                }
            }
        }
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}