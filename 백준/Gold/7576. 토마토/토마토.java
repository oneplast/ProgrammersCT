import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] box;
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        m = parse(token);
        n = parse(token);
        box = new int[n][m];

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            int state;
            for (int j = 0; j < m; j++) {
                state = parse(token);
                box[i][j] = state;
                if (state == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            for (int[] dir : dirs) {
                int ny = y + dir[0];
                int nx = x + dir[1];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && box[ny][nx] == 0) {
                    box[ny][nx] = box[y][x] + 1;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.print(-1);
                    return;
                } else if (box[i][j] > 0) {
                    max = Math.max(max, box[i][j]);
                }
            }
        }

        System.out.print(max - 1);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}