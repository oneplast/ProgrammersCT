import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        points = new int[n + 1][2];

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            int x = parse(token);
            int y = parse(token);
            points[i] = new int[]{x, y};
        }

        long total = 0;
        points[n] = points[0];
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];

            total += calculate(x1, y1, x2, y2);
        }

        System.out.printf("%.1f", Math.abs(total) / 2.0);
    }

    private static long calculate(int x1, int y1, int x2, int y2) {
        return (long) x1 * y2 - (long) x2 * y1;
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}