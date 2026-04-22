import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        StringTokenizer token;

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = parse(token);
            }
        }

        dfs(0, 0, n);

        System.out.print(white + "\n" + blue);
    }

    private static void dfs(int x, int y, int size) {
        int color = paper[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (color != paper[i][j]) {
                    int half = size / 2;
                    dfs(x, y, half);
                    dfs(x + half, y, half);
                    dfs(x, y + half, half);
                    dfs(x + half, y + half, half);
                    return;
                }
            }
        }

        if (color == 0) {
            white++;
        } else {
            blue++;
        }
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}