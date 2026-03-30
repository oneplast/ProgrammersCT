import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int cur;
        StringBuilder sb = new StringBuilder();
        while (cnt <= n || !stack.isEmpty()) {
            cur = Integer.parseInt(br.readLine());
            while (cnt <= cur) {
                stack.push(cnt);
                sb.append("+").append("\n");
                cnt++;
            }

            if (stack.isEmpty() || stack.peek() != cur) {
                System.out.print("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.print(sb);
    }
}