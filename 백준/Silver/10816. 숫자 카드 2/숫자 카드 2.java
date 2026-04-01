import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 10_000_000;
    static int n, m;
    static int[] cntArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cntArr = new int[MAX + MAX + 1];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cntArr[parse(token) + MAX]++;
        }

        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(cntArr[parse(token) + MAX]).append(i < m - 1 ? " " : "");
        }

        System.out.print(sb);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}