import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }

        for (int weight : map.keySet()) {
            int val = map.get(weight);

            if (val > 1) {
                result += (long) val * (val - 1) / 2;
            }

            if (map.containsKey(weight * 3 / 2) && weight % 2 == 0) {
                result += (long) val * map.get(weight * 3 / 2);
            }

            if (map.containsKey(weight * 2)) {
                result += (long) val * map.get(weight * 2);
            }

            if (map.containsKey(weight * 4 / 3) && weight % 3 == 0) {
                result += (long) val * map.get(weight * 4 / 3);
            }
        }

        return result;
    }
}