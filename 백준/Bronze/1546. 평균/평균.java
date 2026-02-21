import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.MIN_VALUE;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = parse(token);
            m = Math.max(m, num);
            nums.add(num);
        }

        int maxM = m;
        double sum = Arrays.stream(nums.stream()
                .mapToDouble(x -> (double) x / maxM * 100)
                .toArray()).sum();

        double result = sum / n;

        System.out.println(result);
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}