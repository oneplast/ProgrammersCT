import java.util.*;

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if (y == n - 1 && x == m - 1) {
                return cnt;
            }

            for (int[] dir : dirs) {
                int nextX = cur[0] + dir[1];
                int nextY = cur[1] + dir[0];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && !visited[nextY][nextX] && maps[nextY][nextX] == 1) {
                    q.add(new int[]{nextX, nextY, cnt + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }

        return -1;
    }
}
