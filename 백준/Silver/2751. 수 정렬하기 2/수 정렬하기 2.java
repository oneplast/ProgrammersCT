import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        set.stream()
                .sorted(Integer::compareTo)
                .forEach(data -> sb.append(data).append("\n"));

        System.out.print(sb);
    }
}