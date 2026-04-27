import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v1, v2, v3;
        int[] arr = new int[3];

        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        while (true) {
            token = new StringTokenizer(br.readLine());
            v1 = parse(token);
            v2 = parse(token);
            v3 = parse(token);

            if (v1 == 0 && v2 == 0 && v3 == 0) {
                System.out.print(sb);
                return;
            }

            arr[0] = v1;
            arr[1] = v2;
            arr[2] = v3;

            Arrays.sort(arr);

            if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }

            sb.append("\n");
        }
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}