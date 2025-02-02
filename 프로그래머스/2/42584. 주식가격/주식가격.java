import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            result[pop] = prices.length - pop - 1;
        }

        return result;
    }
}
