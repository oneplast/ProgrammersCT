import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<int[]>[] graph;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int from, to, weight;
        StringTokenizer token;
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            from = parse(token);
            to = parse(token);
            weight = parse(token);

            graph[from].add(new int[]{to, weight});
        }

        int start, end;
        token = new StringTokenizer(br.readLine());
        start = parse(token);
        end = parse(token);

        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dijkstra(start);

        System.out.println(dp[end]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{start, 0});
        dp[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int to = cur[0];
            int weight = cur[1];

            if (dp[to] < weight) {
                continue;
            }

            for (int[] adjNodes : graph[to]) {
                int adjTo = adjNodes[0];
                int adjWeight = adjNodes[1];

                if (dp[adjTo] > weight + adjWeight) {
                    dp[adjTo] = weight + adjWeight;
                    pq.offer(new int[]{adjTo, dp[adjTo]});
                }
            }
        }
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}