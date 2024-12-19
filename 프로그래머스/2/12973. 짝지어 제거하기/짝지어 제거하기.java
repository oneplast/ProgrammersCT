import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        int idx = 0;
        while (idx < s.length()) {
            char ch = s.charAt(idx);
            if (stack.isEmpty()) {
                stack.push(ch);
                idx++;
                continue;
            }

            if (stack.peek() == ch) {
                stack.pop();
                idx++;
                continue;
            }

            stack.push(ch);
            idx++;
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
