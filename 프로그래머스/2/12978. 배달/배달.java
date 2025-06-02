import java.util.*;

class Solution {
    static int INF = Integer.MAX_VALUE;

    public int solution(int N, int[][] road, int K) {
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] rd : road) {
            graph.get(rd[0]).add(new Node(rd[1], rd[2]));
            graph.get(rd[1]).add(new Node(rd[0], rd[2]));
        }

        int[] dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = INF;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node adjNode : graph.get(cur.to)) {
                if (dp[adjNode.to] > cur.weight + adjNode.weight) {
                    dp[adjNode.to] = cur.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dp[adjNode.to]));
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (dp[i] <= K) {
                result++;
            }
        }

        return result;
    }

    private static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
