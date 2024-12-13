import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = Arrays.stream(array).boxed().collect(Collectors.toMap(
                key -> key,
                value -> 1,
                Integer::sum
        ));

        Map<Integer, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        int key = 0;
        int value = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if (key == 0 && value == 0) {
                key = entry.getKey();
                value = entry.getValue();
                continue;
            }

            if (value == entry.getValue()) {
                return -1;
            } else {
                return key;
            }
        }

        return key;
    }
}