import java.util.*;

class Solution {
    static final int INF = 1_000_000;

    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = INF;
        }
        dp[1] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int to = cur[0];
            int weight = cur[1];

            for (int adj : graph.get(to)) {
                if (dp[adj] == INF) {
                    dp[adj] = weight + 1;
                    queue.offer(new int[]{adj, dp[adj]});
                }
            }
        }

        int result = 1;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] < INF && dp[i] > max) {
                result = 1;
                max = dp[i];
            } else if (dp[i] == max) {
                result++;
            }
        }

        return result;
    }
}