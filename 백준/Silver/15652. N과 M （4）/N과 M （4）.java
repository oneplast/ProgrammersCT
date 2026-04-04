import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int n, m;
    static int[] arr, cur;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        m = parse(token);
        arr = IntStream.rangeClosed(1, n).toArray();
        cur = new int[m];

        dfs(1, 0);

        System.out.print(sb);
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            Arrays.stream(cur).forEach(str -> sb.append(str).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            cur[depth] = i;
            dfs(i, depth + 1);
        }
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}