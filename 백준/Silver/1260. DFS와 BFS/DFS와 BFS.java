import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = parse(token);
        int m = parse(token);
        int v = parse(token);

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());

            int v1 = parse(token);
            int v2 = parse(token);

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(v, visited);

        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(v, visited);

        System.out.println(sb.toString());
    }

    public static void dfs(int v, boolean[] visited) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        sb.append(v).append(" ");

        for (int i = 0; i < graph[v].size(); i++) {
            int nextV = graph[v].get(i);

            if (visited[nextV]) {
                continue;
            }

            dfs(nextV, visited);
        }
    }

    public static void bfs(int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            sb.append(cur).append(" ");

            for (Integer nextV : graph[cur]) {
                if (!visited[nextV]) {
                    visited[nextV] = true;
                    queue.offer(nextV);
                }
            }
        }
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}
