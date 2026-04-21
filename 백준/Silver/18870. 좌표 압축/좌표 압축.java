import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parse(token);
        }

        Map<Integer, Integer> rankedMap = new HashMap<>();

        int[] rankedArr = Arrays.stream(arr)
                .distinct()
                .sorted()
                .toArray();

        for (int i = 0; i < rankedArr.length; i++) {
            rankedMap.put(rankedArr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(rankedMap.get(x)).append(" ");
        }

        System.out.print(sb);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}