import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] cost : costs) {
            graph.get(cost[0]).add(new Node(cost[1], cost[2]));
            graph.get(cost[1]).add(new Node(cost[0], cost[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[n];
        pq.offer(new Node(0, 0));

        int weightSum = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to]) {
                continue;
            }
            
            visited[cur.to] = true;
            weightSum += cur.weight;

            for (Node adjNode : graph.get(cur.to)) {
                if (!visited[adjNode.to]) {
                    pq.offer(new Node(adjNode.to, adjNode.weight));
                }
            }
        }

        return weightSum;
    }

    private static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}