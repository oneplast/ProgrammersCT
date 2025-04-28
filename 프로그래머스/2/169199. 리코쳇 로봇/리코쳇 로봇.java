import java.util.*;

class Solution {
    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        loop:
        for (int i = 0; i < n; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (chars[j] == 'R') {
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                    break loop;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[1];
            int y = cur[0];
            int cnt = cur[2];

            if (board[y].charAt(x) == 'G') {
                return cnt;
            }

            for (int[] dir : dirs) {
                int nextX = x + dir[1];
                int nextY = y + dir[0];

                while (true) {
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && board[nextY].charAt(nextX) != 'D') {
                        nextX += dir[1];
                        nextY += dir[0];
                    } else {
                        nextX -= dir[1];
                        nextY -= dir[0];
                        break;
                    }
                }

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX, cnt + 1});
                }
            }
        }

        return -1;
    }
}