import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();

            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < wires.length; j++) {
                if (i != j) {
                    graph.get(wires[j][0]).add(wires[j][1]);
                    graph.get(wires[j][1]).add(wires[j][0]);
                }
            }

            int part1 = dfs(graph, new boolean[n + 1], 1);
            int part2 = n - part1;

            diff = Math.min(diff, Math.abs(part1 - part2));
        }

        return diff;
    }

    private int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        int cnt = 1;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                cnt += dfs(graph, visited, next);
            }
        }

        return cnt;
    }
}