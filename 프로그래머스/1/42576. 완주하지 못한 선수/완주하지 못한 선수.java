import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completionMap = new HashMap<>();
        for (String person : completion) {
            completionMap.merge(person, 1, Integer::sum);
        }
        
        for (String person : participant) {
            if (!completionMap.containsKey(person)) {
                return person;
            } else {
                completionMap.compute(person, (k, v) -> v == 1 ? null : v - 1);
            }
        }
        
        return "";
    }
}