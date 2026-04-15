import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        m = parse(token);
        heights = new int[n];

        long max = Long.MIN_VALUE;
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int height = parse(token);
            heights[i] = height;
            max = Math.max(max, height);
        }

        long left = 0;
        long right = max;
        long mid, total;
        while (left <= right) {
            total = 0;
            mid = (left + right) / 2;

            for (int height : heights) {
                if (height > mid) {
                    total += (height - mid);
                }
            }

            if (total >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(right);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}