import java.util.*;
import java.util.stream.*;

class Solution {

    int n;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Queue<Point> queue = new LinkedList<>();

    public int solution(int[][] board) {
        n = board.length;
        int[][][] arr = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(arr[i][j], Integer.MAX_VALUE);
            }
        }

        if (board[0][1] == 0) {
            arr[0][1][0] = 100;
            queue.offer(new Point(0, 1, 100, 0));
        }

        if (board[1][0] == 0) {
            arr[1][0][1] = 100;
            queue.offer(new Point(1, 0, 100, 1));
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < dirs.length; i++) {
                int nextY = cur.y + dirs[i][0];
                int nextX = cur.x + dirs[i][1];

                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n
                        && board[nextY][nextX] == 0) {
                    int nextWeight = cur.weight + (cur.direction == i ? 100 : 600);

                    if (arr[nextY][nextX][i] > nextWeight) {
                        arr[nextY][nextX][i] = nextWeight;
                        queue.offer(new Point(nextY, nextX, nextWeight, i));
                    }
                }
            }
        }

        return Arrays.stream(arr[n - 1][n - 1])
                .min().getAsInt();
    }

    static class Point {
        int y;
        int x;
        int weight;
        int direction;

        public Point(int y, int x, int weight, int direction) {
            this.y = y;
            this.x = x;
            this.weight = weight;
            this.direction = direction;
        }
    }
}
