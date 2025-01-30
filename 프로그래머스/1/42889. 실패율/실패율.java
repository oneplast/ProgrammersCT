import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int total = stages.length;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(stages).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        Data[] data = new Data[N];

        for (int i = 1; i <= N; i++) {
            if (map.containsKey(i)) {
                data[i - 1] = new Data(i, (double) map.get(i) / total);
                total -= map.get(i);
            } else {
                data[i - 1] = new Data(i, 0);
            }
        }

        Arrays.sort(data);

        return Arrays.stream(data)
                .mapToInt(x -> x.stage)
                .toArray();
    }
}

class Data implements Comparable<Data> {
    int stage;
    double rate;

    public Data(int stage, double rate) {
        this.stage = stage;
        this.rate = rate;
    }

    @Override
    public int compareTo(Data o) {
        if (this.rate == o.rate) {
            return this.stage - o.stage;
        }

        return Double.compare(o.rate, this.rate);
    }
}