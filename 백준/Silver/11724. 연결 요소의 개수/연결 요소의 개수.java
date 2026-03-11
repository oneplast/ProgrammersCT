import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = parse(token);
        m = parse(token);

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int from, to;
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            from = parse(token);
            to = parse(token);

            graph[from].add(to);
            graph[to].add(from);
        }

        boolean[] visited = new boolean[n + 1];
        int totalCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(visited, i);
                totalCnt++;
            }
        }

        System.out.print(totalCnt);
    }

    public static void bfs(boolean[] visited, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int newTo : graph[cur]) {
                if (!visited[newTo]) {
                    visited[newTo] = true;
                    queue.offer(newTo);
                }
            }
        }
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}