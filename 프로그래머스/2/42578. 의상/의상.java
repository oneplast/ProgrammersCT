import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> typeMap = new HashMap<>();

        for (String[] cloth : clothes) {
            typeMap.put(cloth[1], typeMap.getOrDefault(cloth[1], 0) + 1);
        }

        return typeMap.values().stream()
                .reduce(1, (a, b) -> a * (b + 1)) - 1;
    }
}