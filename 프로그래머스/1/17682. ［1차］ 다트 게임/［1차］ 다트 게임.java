import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        char[] chars = dartResult.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == 'S' || ch == 'D' || ch == 'T') {
                int newScore = calculate(stack.pop(), ch);
                stack.push(newScore);
                continue;
            }

            if (ch == '*') {
                int newScore = stack.pop() * 2;

                if (!stack.isEmpty()) {
                    stack.push(stack.pop() * 2);
                }

                stack.push(newScore);
                continue;
            } else if (ch == '#') {
                stack.push(-stack.pop());
                continue;
            }

            if (ch == '0') {
                if ((i - 1) >= 0 && chars[i - 1] == '1') {
                    stack.pop();
                    stack.push(10);
                    continue;
                }
            }

            stack.push(ch - '0');
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }

    public int calculate(int score, char area) {
        if (area == 'S') {
            return score;
        } else if (area == 'D') {
            return (int) Math.pow(score, 2);
        } else {
            return (int) Math.pow(score, 3);
        }
    }
}