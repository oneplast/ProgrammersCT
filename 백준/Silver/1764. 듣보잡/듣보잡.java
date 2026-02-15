import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        List<String> resultNames = new ArrayList<>();
        map.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .forEach(entry -> resultNames.add(entry.getKey()));

        StringBuilder sb = new StringBuilder();
        sb.append(resultNames.size()).append("\n");
        for (String resultName : resultNames) {
            sb.append(resultName).append("\n");
        }

        System.out.println(sb);
    }
}