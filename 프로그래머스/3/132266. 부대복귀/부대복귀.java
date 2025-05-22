import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] result = new int[sources.length];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }

        int idx = 0;
        for (int source : sources) {
            if (source == destination) {
                result[idx++] = 0;
                continue;
            }

            Queue<int[]> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            queue.offer(new int[]{source, 0});

            boolean isPossible = false;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int weight = cur[1];

                List<Integer> curList = graph.get(cur[0]);

                if (curList.isEmpty()) {
                    break;
                }

                for (int to : curList) {
                    if (to == destination) {
                        isPossible = true;
                        result[idx++] = weight + 1;
                        break;
                    }

                    if (!visited[to]) {
                        queue.offer(new int[]{to, weight + 1});
                        visited[to] = true;
                    }
                }

                if (isPossible) {
                    break;
                }
            }

            if (!isPossible) {
                result[idx++] = -1;
            }
        }

        return result;
    }
}