import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static final int MAX = 20;
    static int m;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());

        StringTokenizer token;
        String oper;
        int num = 0;
        for (int i = 0; i < m; i++) {
            boolean isSingle = true;
            token = new StringTokenizer(br.readLine());
            oper = token.nextToken();
            if (token.hasMoreTokens()) {
                isSingle = false;
                num = parse(token);
            }

            if (isSingle) {
                singleOperate(oper);
            } else {
                multiOperate(oper, num);
            }
        }

        System.out.print(sb);
    }

    private static void singleOperate(String oper) {
        switch (oper) {
            case "all":
                set = IntStream.rangeClosed(1, MAX).boxed().collect(Collectors.toSet());
                break;
            case "empty":
                set = new HashSet<>();
                break;
        }
    }

    private static void multiOperate(String oper, int num) {
        switch (oper) {
            case "add":
                set.add(num);
                break;
            case "remove":
                set.remove(num);
                break;
            case "toggle":
                if (!set.add(num)) {
                    set.remove(num);
                }
                break;
            case "check":
                sb.append(set.contains(num) ? 1 : 0).append("\n");
                break;
        }
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}