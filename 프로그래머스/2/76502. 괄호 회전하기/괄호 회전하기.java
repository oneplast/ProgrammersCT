import java.util.*;

class Solution {
    public int solution(String s) {
        int result = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        int idx = 0;
        while (idx < s.length()) {
            String curStr = s.substring(idx) + s.substring(0, idx);
            Stack<Character> stack = new Stack<>();

            int strIdx = 0;
            while (strIdx <= s.length()) {
                if (strIdx == s.length()) {
                    if (stack.isEmpty()) {
                        result++;
                    }

                    break;
                }

                Character ch = curStr.charAt(strIdx++);
                if (strIdx == 1 && map.containsKey(ch)) {
                    break;
                }

                if (stack.isEmpty()) {
                    stack.push(ch);
                    continue;
                }

                if (map.containsKey(ch)) {
                    Character pop = stack.pop();
                    if (!pop.equals(map.get(ch))) {
                        break;
                    }
                } else {
                    stack.push(ch);
                }
            }

            idx++;
        }

        return result;
    }
}
