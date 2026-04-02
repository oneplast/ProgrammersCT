import java.io.*;
import java.util.*;

public class Main {
    static long a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        a = parse(token);
        b = parse(token);

        long cur = b;
        int result = 1;
        while (true) {
            if (cur % 10 == 1) {
                cur /= 10;
            } else if (cur % 2 == 0) {
                cur /= 2;
            } else {
                System.out.print(-1);
                return;
            }

            result++;

            if (cur == a) {
                System.out.print(result);
                return;
            } else if (cur < a) {
                System.out.print(-1);
                return;
            }
        }
    }

    private static long parse(StringTokenizer token) {
        return Long.parseLong(token.nextToken());
    }
}