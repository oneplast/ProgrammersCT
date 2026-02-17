import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = parse(token);
        int k = parse(token);

        List<int[]> jewelInfos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            int m = parse(token);
            int v = parse(token);

            jewelInfos.add(new int[]{m, v});
        }

        jewelInfos.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        bags.sort(Comparator.naturalOrder());

        int jewelIdx = 0;
        int bagWeight;

        long result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            bagWeight = bags.get(i);

            while (jewelIdx < n && jewelInfos.get(jewelIdx)[0] <= bagWeight) {
                pq.offer(jewelInfos.get(jewelIdx)[1]);
                ++jewelIdx;
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}