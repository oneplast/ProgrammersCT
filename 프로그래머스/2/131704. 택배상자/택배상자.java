import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for (int i = 1; i <= order.length; i++) {
            if (order[idx] == i) {
                idx++;
                answer++;
            } else {
                stack.push(i);
            }

            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            }
        }

        return answer;
    }
}