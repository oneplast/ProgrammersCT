import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> comp = new HashMap<>();

        for (int i = 0; i < completion.length; i++) {
            comp.put(completion[i], comp.getOrDefault(completion[i], 0) + 1);
        }

        for (int i = 0; i < participant.length; i++) {
            if (!comp.containsKey(participant[i]) || comp.get(participant[i]) == 0) {
                return participant[i];
            } else {
                comp.put(participant[i], comp.get(participant[i]) - 1);
            }
        }

        return "";
    }
}