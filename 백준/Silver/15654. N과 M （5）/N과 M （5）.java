import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] orgArr, results;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        m = parse(token);

        orgArr = new int[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            orgArr[i] = parse(token);
        }

        Arrays.sort(orgArr);

        results = new int[m];
        visited = new boolean[n];
        dfs(0);

        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            Arrays.stream(results).forEach(str -> sb.append(str).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                results[depth] = orgArr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}