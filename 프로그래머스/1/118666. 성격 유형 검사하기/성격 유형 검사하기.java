import java.util.*;

class Solution {
    String[] types = {"RT", "CF", "JM", "AN"};

    public String solution(String[] survey, int[] choices) {
        int mid = 4;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < types.length; i++) {
            map.put(types[i].charAt(0), 0);
            map.put(types[i].charAt(1), 0);
        }

        for (int i = 0; i < choices.length; i++) {
            int cur = choices[i];
            int numData = Math.abs(mid - cur);
            if (cur > mid) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + numData);
            } else if (cur < mid) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + numData);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String type : types) {
            char char1 = type.charAt(0);
            char char2 = type.charAt(1);

            if (map.get(char1) > map.get(char2)) {
                sb.append(char1);
            } else if (map.get(char1) < map.get(char2)) {
                sb.append(char2);
            } else {
                if (char1 - char2 < 0) {
                    sb.append(char1);
                } else {
                    sb.append(char2);
                }
            }
        }

        return sb.toString();
    }
}