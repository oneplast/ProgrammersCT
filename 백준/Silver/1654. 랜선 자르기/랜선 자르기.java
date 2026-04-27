import java.io.*;
import java.util.*;

public class Main {
    static int k, n;
    static int[] lans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        k = parse(token);
        n = parse(token);

        lans = new int[k];
        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lans);

        long result = 0;
        long left = 1;
        long right = lans[k - 1];
        while (left <= right) {
            long mid = (left + right) / 2;

            long total = 0;
            for (int lan : lans) {
                total += lan / mid;
            }

            if (total >= n) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(result);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}