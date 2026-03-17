import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int n;
    static List<int[]> pair = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            pair.add(new int[]{i, parse(token)});
        }

        pair = pair.stream()
                .sorted((a, b) -> a[1] - b[1])
                .collect(Collectors.toList());

        int result = 0;
        int sum = 0;
        for (int[] arr : pair) {
            sum += arr[1];
            result += sum;
        }

        System.out.print(result);
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}