import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100_000;
    static int n, k;
    static Queue<Integer> queue = new ArrayDeque<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        k = parse(token);

        dist = new int[MAX + 1];
        Arrays.fill(dist, -1);
        queue.offer(n);
        dist[n] = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == k) {
                System.out.print(dist[x]);
                return;
            }

            int nextX = x + 1;
            if (nextX <= MAX && dist[nextX] == -1) {
                addBfs(x, nextX);
            }

            nextX = x - 1;
            if (nextX >= 0 && dist[nextX] == -1) {
                addBfs(x, nextX);
            }

            nextX = x * 2;
            if (nextX <= MAX && dist[nextX] == -1) {
                addBfs(x, nextX);
            }
        }
    }

    private static void addBfs(int x, int nextX) {
        dist[nextX] = dist[x] + 1;
        queue.offer(nextX);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}