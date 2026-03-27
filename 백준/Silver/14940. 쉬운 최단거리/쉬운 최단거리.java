import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] orgBoard;
    static int[][] resultBoard;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = parse(token);
        m = parse(token);
        orgBoard = new int[n][m];
        resultBoard = new int[n][m];
        visited = new boolean[n][m];

        int[] start = new int[0];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                orgBoard[i][j] = parse(token);
                if (orgBoard[i][j] == 2) {
                    start = new int[]{i, j};
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[1];
            int y = cur[0];

            for (int[] dir : dirs) {
                int nextX = x + dir[1];
                int nextY = y + dir[0];

                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m
                        && !visited[nextY][nextX] && orgBoard[nextY][nextX] == 1) {
                    queue.offer(new int[]{nextY, nextX});
                    resultBoard[nextY][nextX] = resultBoard[y][x] + 1;
                    visited[nextY][nextX] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (resultBoard[i][j] == 0) {
                    sb.append(orgBoard[i][j] == 1 ? -1 : 0);
                } else {
                    sb.append(resultBoard[i][j]);
                }
                sb.append(j < m - 1 ? " " : "");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}