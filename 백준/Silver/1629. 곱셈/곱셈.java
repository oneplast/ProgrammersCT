import java.io.*;
import java.util.*;

public class Main {
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        a = parse(token);
        b = parse(token);
        c = parse(token);

        long result = 1;
        long base = a % c;

        while (b > 0) {
            if ((b % 2) == 1) {
                result = result * base % c;
            }

            base = base * base % c;
            b /= 2;
        }

        System.out.println(result);
    }

    public static long parse(StringTokenizer token) {
        return Long.parseLong(token.nextToken());
    }
}