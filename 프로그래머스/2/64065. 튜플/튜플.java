import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();

        String[] strBits = s.replaceAll("[{}]", "").split(",");

        for (String strBit : strBits) {
            int key = Integer.parseInt(strBit);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
