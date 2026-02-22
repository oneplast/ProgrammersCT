import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[] arr = new int[m + 1];
        visited = new boolean[n + 1];
        permutation(arr, n, m, 1);

        System.out.println(sb);
    }

    public static void permutation(int[] arr, int n, int m, int depth) {
        if (depth > m) {
            for (int i = 1; i <= m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = depth; i <= n; i++) {
            if (!visited[i] && arr[depth - 1] < i) {
                visited[i] = true;
                arr[depth] = i;
                permutation(arr, n, m, depth + 1);
                arr[depth] = 0;
                visited[i] = false;
            }
        }
    }
}