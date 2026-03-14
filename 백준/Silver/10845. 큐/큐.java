import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token;

        String operation;
        int number;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());

            operation = token.nextToken();
            if (operation.equals("push")) {
                number = Integer.parseInt(token.nextToken());
                queue.offer(number);

                continue;
            }

            operate(operation);
        }

        System.out.println(sb);
    }

    public static void operate(String operation) {
        switch (operation) {
            case "pop":
                sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append("\n");
                break;
            case "size":
                sb.append(queue.size()).append("\n");
                break;
            case "empty":
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                break;
            case "front":
                sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
                break;
            case "back":
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                break;
        }
    }
}