import java.util.*;

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0 ,-1}, {-1, 0}};
    
    public int[][] solution(int n) {
        int[][] board = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[n][n];
        board[0][0] = 1;
        visited[0][0] = true;
        int data = 2;
        int dirIdx = 0;

        while (data <= n * n) {
            int[] cur = q.poll();

            int x = cur[1] + dirs[dirIdx][1];
            int y = cur[0] + dirs[dirIdx][0];

            if (x >= 0 && y >= 0 && x < n && y < n && !visited[y][x]) {
                board[y][x] = data;
                q.offer(new int[]{y, x});
                visited[y][x] = true;
                data++;
            } else {
                dirIdx = (dirIdx + 1) % dirs.length;
                q.offer(cur);
            }
        }

        return board;
    }
}
