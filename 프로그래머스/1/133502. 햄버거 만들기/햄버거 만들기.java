import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int cur : ingredient) {
            stack.push(cur);
            int n = stack.size();

            if (stack.size() >= 4 && stack.peek() == 1) {
                if (stack.get(n - 2) == 3 && stack.get(n - 3) == 2 && stack.get(n - 4) == 1) {
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                    result++;
                }
            }
        }

        return result;
    }
}