import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        // 각 의상을 입거나 안 입거나 의 경우의 수 -> value + 1
        // 아무 것도 입지 않았을 때 -> 1 (제외)
        return map.values().stream().reduce(1, (a, b) -> a * (b + 1)) - 1;
    }
}