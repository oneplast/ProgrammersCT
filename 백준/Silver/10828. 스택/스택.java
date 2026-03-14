import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token;

        String operation;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            operation = token.nextToken();

            if (token.hasMoreTokens()) {
                stack.addFirst(Integer.parseInt(token.nextToken()));
            } else {
                operate(operation);
            }
        }

        System.out.print(sb);
    }

    public static void operate(String operation) {
        switch (operation) {
            case "pop":
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                break;
            case "size":
                sb.append(stack.size()).append("\n");
                break;
            case "empty":
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                break;
            case "top":
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                break;
        }
    }
}