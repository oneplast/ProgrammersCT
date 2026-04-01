import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }

        while (dq.size() > 1) {
            dq.poll();
            dq.offer(dq.poll());
        }

        System.out.print(dq.poll());
    }
}