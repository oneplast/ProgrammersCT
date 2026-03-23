import java.io.*;
import java.util.*;

public class Main {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringTokenizer token;

        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue;
        int n, m;
        for (int i = 0; i < t; i++) {
            queue = new ArrayDeque<>();
            token = new StringTokenizer(br.readLine());
            n = parse(token);
            m = parse(token);
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                queue.offer(new int[]{j, parse(token)});
            }

            int cnt = 0;
            while (true) {
                int[] cur = queue.poll();

                boolean isPossible = true;
                for (int[] data : queue) {
                    if (data[1] > cur[1]) {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    cnt++;
                    if (cur[0] == m) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                } else {
                    queue.offer(cur);
                }
            }
        }

        System.out.print(sb);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}