import java.util.*;

class Solution {
    List<String> results;

    public String[] solution(String[][] tickets) {
        results = new ArrayList<>();
        Map<String, PriorityQueue<Node>> graph = new HashMap<>();

        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], a -> new PriorityQueue<>()).add(new Node(ticket[1]));
        }

        dfs(graph, "ICN");
        Collections.reverse(results);

        return results.toArray(new String[0]);
    }

    private void dfs(Map<String, PriorityQueue<Node>> graph, String from) {
        PriorityQueue<Node> pq = graph.get(from);

        while (pq != null && !pq.isEmpty()) {
            dfs(graph, pq.poll().to);
        }

        results.add(from);
    }

    static class Node implements Comparable<Node> {
        String to;

        public Node(String to) {
            this.to = to;
        }

        @Override
        public int compareTo(Node o) {
            return this.to.compareTo(o.to);
        }
    }
}