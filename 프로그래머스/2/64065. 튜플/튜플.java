import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        String fullStr = s.substring(2, s.length() - 1);

        String[] strs = fullStr.split(",\\{");

        for (String str : strs) {
            str = str.substring(0, str.length() - 1);
            for (String checkStr : str.split(",")) {
                int key = Integer.parseInt(checkStr);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        for (Map.Entry<Integer, Integer> dataMap : sortedMap.entrySet()) {
            resultList.add(dataMap.getKey());
        }

        return resultList.stream().mapToInt(x -> x).toArray();
    }
}
