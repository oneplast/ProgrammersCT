import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Map<String, String> mailSet = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        m = parse(token);

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            mailSet.put(token.nextToken(), token.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            sb.append(mailSet.get(token.nextToken())).append("\n");
        }

        System.out.print(sb);
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}