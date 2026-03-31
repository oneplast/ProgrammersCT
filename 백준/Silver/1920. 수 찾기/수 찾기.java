import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(parse(token));
        }

        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(set.contains(parse(token)) ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}