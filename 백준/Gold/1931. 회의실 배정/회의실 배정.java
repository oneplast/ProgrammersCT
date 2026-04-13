import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        StringTokenizer token;

        int start, end;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            start = parse(token);
            end = parse(token);
            pq.offer(new int[]{start, end});
        }

        int result = 0;
        int preEnd = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            start = cur[0];
            end = cur[1];

            if (start >= preEnd) {
                result++;
                preEnd = end;
            }
        }

        System.out.print(result);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}