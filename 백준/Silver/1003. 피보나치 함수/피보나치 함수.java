import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp0;
    static int[] dp1;
    static final int MAX = 40;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int cnt = 0;

        dp0 = new int[MAX + 1];
        dp1 = new int[MAX + 1];

        dp0[0] = 1;
        dp0[1] = 0;
        dp1[0] = 0;
        dp1[1] = 1;

        for (int i = 0; i < dp0.length; i++) {
            fabo(i);
        }

        StringBuilder sb = new StringBuilder();

        while (cnt < t) {
            sb.setLength(0);

            int n = Integer.parseInt(br.readLine());

            sb.append(dp0[n]).append(" ").append(dp1[n]);
            System.out.println(sb);

            ++cnt;
        }
    }

    public static void fabo(int n) {
        if (n <= 1) {
            return;
        }

        dp0[n] = dp0[n - 1] + dp0[n - 2];
        dp1[n] = dp1[n - 1] + dp1[n - 2];
    }
}
