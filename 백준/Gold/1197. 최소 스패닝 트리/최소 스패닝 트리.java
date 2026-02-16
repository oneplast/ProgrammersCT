import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int v = parse(token);
        int e = parse(token);

        List<Node>[] graph = new ArrayList[v + 1];

        for (int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        int to;
        int from;
        int weight;
        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine());
            from = parse(token);
            to = parse(token);
            weight = parse(token);

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});

        boolean[] visited = new boolean[v + 1];

        int cnt = 0;
        int result = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            to = cur[0];
            weight = cur[1];

            if (visited[to]) {
                continue;
            }

            visited[to] = true;
            result += weight;
            ++cnt;

            if (cnt == v) {
                break;
            }

            for (Node node : graph[to]) {
                if (!visited[node.to]) {
                    pq.offer(new int[]{node.to, node.weight});
                }
            }
        }

        System.out.println(result);
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
