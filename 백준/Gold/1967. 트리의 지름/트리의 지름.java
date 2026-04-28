import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int startNode = 1;
    static int maxDist = 0;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            int from = parse(token);
            int to = parse(token);
            int weight = parse(token);
            graph[from].add(new int[]{to, weight});
            graph[to].add(new int[]{from, weight});
        }

        boolean[] visited = makeVisited(startNode);
        dfs(startNode, 0, visited);

        visited = makeVisited(startNode);
        dfs(startNode, 0, visited);

        System.out.print(maxDist);
    }

    private static void dfs(int node, int dist, boolean[] visited) {
        if (dist > maxDist) {
            maxDist = dist;
            startNode = node;
        }

        for (int[] adj : graph[node]) {
            int nextNode = adj[0];
            int nextDist = adj[1];
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode, dist + nextDist, visited);
            }
        }
    }

    private static boolean[] makeVisited(int startNode) {
        boolean[] visited = new boolean[n + 1];
        visited[startNode] = true;

        return visited;
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}