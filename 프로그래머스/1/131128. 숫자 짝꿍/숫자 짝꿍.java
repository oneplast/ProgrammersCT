import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        for (String xKey : X.split("")) {
            xMap.put(xKey, xMap.getOrDefault(xKey, 0) + 1);
        }

        for (String yKey : Y.split("")) {
            yMap.put(yKey, yMap.getOrDefault(yKey, 0) + 1);
        }

        Map<String, Integer> comMap = new TreeMap<>(Collections.reverseOrder());

        for (String key : xMap.keySet()) {
            if (yMap.containsKey(key)) {
                comMap.put(key, Math.min(xMap.get(key), yMap.get(key)));
            }
        }

        if (comMap.isEmpty()) {
            return "-1";
        } else if (comMap.size() == 1 && comMap.containsKey("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : comMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}