import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(tangerine).forEach(x -> {
            map.put(x, map.getOrDefault(x, 0) + 1);
        });

        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .collect(Collectors.toList());

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            if (cnt >= k) {
                break;
            }

            cnt += entry.getValue();
            set.add(entry.getKey());
        }

        return set.size();
    }
}
