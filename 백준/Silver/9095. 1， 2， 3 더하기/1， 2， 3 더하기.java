import java.io.*;

public class Main {
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            total = 0;
            int n = Integer.parseInt(br.readLine());

            dfs(n);
            System.out.println(total);
        }
    }

    public static void dfs(int n) {
        if (n == 0) {
            ++total;
            return;
        }

        if (n < 0) {
            return;
        }

        dfs(n - 1);
        dfs(n - 2);
        dfs(n - 3);
    }
}
