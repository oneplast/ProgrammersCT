import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();
        Queue<String> q = new LinkedList<>();
        Arrays.stream(words).forEach(q::offer);

        int num = 1;
        int turn = 0;
        while (turn < words.length && !q.isEmpty()) {
            String cur = q.poll();

            if (!set.contains(cur)) {
                if (!stack.isEmpty()) {
                    String lastStr = stack.peek();
                    if (lastStr.charAt(lastStr.length() - 1) != cur.charAt(0)) {
                        return new int[]{turn % n + 1, num};
                    }
                }

                set.add(cur);
                stack.push(cur);
                turn++;

                if (turn / n == num) {
                    num++;
                }
            } else {
                return new int[]{turn % n + 1, num};
            }
        }

        return new int[]{0, 0};
    }
}
