import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int count = 0;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int from, to;
        for (int i = 1; i <= m; i++) {
            token = new StringTokenizer(br.readLine());
            from = parse(token);
            to = parse(token);
            graph[to].add(from);
            graph[from].add(to);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int adj : graph[cur]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.offer(adj);
                    count++;
                }
            }
        }

        System.out.print(count);
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}