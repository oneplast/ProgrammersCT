import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        k = parse(token);

        Queue<Integer> queue = new ArrayDeque<>();

        IntStream.rangeClosed(1, n)
                .forEach(queue::offer);

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }

            list.add(queue.poll());
        }

        String result = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "<", ">"));

        System.out.println(result);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}