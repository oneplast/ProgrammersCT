import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, results;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        m = parse(token);

        int[] inputArr = new int[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputArr[i] = parse(token);
        }

        arr = Arrays.stream(inputArr)
                .distinct()
                .sorted()
                .toArray();

        n = arr.length;
        results = new int[m];
        dfs(0, 0);

        System.out.print(sb);
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            Arrays.stream(results).forEach(str -> sb.append(str).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            results[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}