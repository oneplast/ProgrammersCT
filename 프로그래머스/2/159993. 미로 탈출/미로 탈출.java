import java.util.*;

class Solution {
    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        loop:
        for (int i = 0; i < n; i++) {
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (chars[j] == 'S') {
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                    break loop;
                }
            }
        }

        Queue<int[]> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[1];
            int y = cur[0];
            int cnt = cur[2];

            if (maps[y].charAt(x) == 'L') {
                nextQueue.offer(new int[]{y, x, cnt});
                break;
            }

            for (int[] dir : dirs) {
                int nextX = x + dir[1];
                int nextY = y + dir[0];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextY][nextX]
                        && maps[nextY].charAt(nextX) != 'X') {
                    visited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX, cnt + 1});
                }
            }
        }

        if (nextQueue.isEmpty()) {
            return -1;
        }

        visited = new boolean[n][m];

        while (!nextQueue.isEmpty()) {
            int[] cur = nextQueue.poll();
            int x = cur[1];
            int y = cur[0];
            int cnt = cur[2];

            if (maps[y].charAt(x) == 'E') {
                return cnt;
            }

            for (int[] dir : dirs) {
                int nextX = x + dir[1];
                int nextY = y + dir[0];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextY][nextX]
                        && maps[nextY].charAt(nextX) != 'X') {
                    visited[nextY][nextX] = true;
                    nextQueue.offer(new int[]{nextY, nextX, cnt + 1});
                }
            }
        }

        return -1;
    }
}