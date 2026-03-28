import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m, k;
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringTokenizer token;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            token = new StringTokenizer(br.readLine());
            m = parse(token);
            n = parse(token);
            k = parse(token);

            int x, y;
            ground = new int[n][m];

            for (int j = 0; j < k; j++) {
                token = new StringTokenizer(br.readLine());
                x = parse(token);
                y = parse(token);
                ground[y][x] = 1;
            }

            int group = 1;
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (ground[a][b] == 1) {
                        group++;
                        dfs(a, b, group);
                    }
                }
            }

            sb.append(group - 1).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int y, int x, int group) {
        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];

            if (ny >= 0 && ny < n && nx >= 0 && nx < m && ground[ny][nx] == 1) {
                ground[ny][nx] = group;
                dfs(ny, nx, group);
            }
        }
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}