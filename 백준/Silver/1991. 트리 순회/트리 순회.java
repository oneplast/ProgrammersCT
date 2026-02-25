import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[] left = new char[26];
    static char[] right = new char[26];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char p, l, r;
        StringTokenizer token;

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            p = parse(token);
            l = parse(token);
            r = parse(token);

            left[p - 'A'] = l;
            right[p - 'A'] = r;
        }

        preOrder('A');
        sb.append("\n");
        inOrder('A');
        sb.append("\n");
        postOrder('A');
        sb.append("\n");

        System.out.println(sb);
    }

    public static void preOrder(char cur) {
        if (cur == '.') {
            return;
        }

        sb.append(cur);
        preOrder(left[cur - 'A']);
        preOrder(right[cur - 'A']);
    }

    public static void inOrder(char cur) {
        if (cur == '.') {
            return;
        }

        inOrder(left[cur - 'A']);
        sb.append(cur);
        inOrder(right[cur - 'A']);
    }

    public static void postOrder(char cur) {
        if (cur == '.') {
            return;
        }

        postOrder(left[cur - 'A']);
        postOrder(right[cur - 'A']);
        sb.append(cur);
    }

    public static char parse(StringTokenizer token) {
        return token.nextToken().charAt(0);
    }
}