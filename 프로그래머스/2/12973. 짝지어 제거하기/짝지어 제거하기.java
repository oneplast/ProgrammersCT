import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if (!deque.isEmpty() && deque.peekLast() == ch) {
                char preCh = deque.pollLast();
                while (!deque.isEmpty() && deque.peekLast() == preCh) {
                    preCh = deque.pollLast();
                }
            } else {
                deque.offerLast(ch);
            }
        }

        return deque.isEmpty() ? 1 : 0;
    }
}