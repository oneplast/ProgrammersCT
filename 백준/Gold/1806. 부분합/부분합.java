import java.io.*;
import java.util.*;

public class Main {
    static int n, s;
    static int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        s = parse(token);

        inputs = new int[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = parse(token);
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = start;
        int total = 0;
        int len = 0;
        while (end < n) {
            while (total < s && end < n) {
                total += inputs[end++];
                len++;
            }

            while (total >= s && start < end) {
                min = Math.min(min, len);
                total -= inputs[start++];
                len--;
            }
        }

        min = min == Integer.MAX_VALUE ? 0 : min;
        System.out.print(min);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}