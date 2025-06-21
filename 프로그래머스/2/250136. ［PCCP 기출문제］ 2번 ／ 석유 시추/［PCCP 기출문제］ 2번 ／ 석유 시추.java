import java.util.*;

class Solution {
    int n, m;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] dp;

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        dp = new int[n][m];
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> oilMap = new HashMap<>();

        int id = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && dp[i][j] == 0) {
                    int weight = bfs(land, j, i, id);
                    oilMap.put(id, weight);
                    ++id;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Set<Integer> visited = new HashSet<>();

            for (int j = 0; j < n; j++) {
                int oilId = dp[j][i];
                if (oilId != 0) {
                    visited.add(oilId);
                }
            }

            int sum = 0;
            for (int oilId : visited) {
                sum += oilMap.get(oilId);
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    private int bfs(int[][] land, int x, int y, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        dp[y][x] = id;

        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[1];
            int curY = cur[0];

            for (int[] dir : dirs) {
                int nextX = curX + dir[1];
                int nextY = curY + dir[0];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (land[nextY][nextX] == 1 && dp[nextY][nextX] == 0) {
                        dp[nextY][nextX] = id;
                        queue.offer(new int[]{nextY, nextX});
                        ++cnt;
                    }
                }
            }
        }

        return cnt;
    }
}