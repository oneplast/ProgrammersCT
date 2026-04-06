import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, results;
    static int[] cntArr = new int[10001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        m = parse(token);

        token = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int data = parse(token);
            cntArr[data]++;
            set.add(data);
        }

        arr = set.stream().sorted()
                .mapToInt(Integer::valueOf)
                .toArray();

        n = arr.length;
        results = new int[m];

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
            if (cntArr[arr[i]] - 1 < 0) {
                continue;
            }

            cntArr[arr[i]]--;
            results[depth] = arr[i];
            dfs(depth + 1);
            cntArr[arr[i]]++;
        }
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}