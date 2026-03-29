import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<int[]> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token;

        int x, y;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            x = parse(token);
            y = parse(token);

            nums.add(new int[]{x, y});
        }

        StringBuilder sb = new StringBuilder();
        nums.stream()
                .sorted((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]))
                .forEach(n -> sb.append(n[0]).append(" ").append(n[1]).append("\n"));

        System.out.print(sb);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}