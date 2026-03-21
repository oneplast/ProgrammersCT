import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Set<String> uniqueWords = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            uniqueWords.add(br.readLine());
        }

        String[] words = uniqueWords.stream()
                .sorted((a, b) -> {
                    if (a.length() == b.length()) {
                        return a.compareTo(b);
                    }

                    return a.length() - b.length();
                })
                .toArray(String[]::new);

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }

        System.out.print(sb);
    }
}