import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int n = board.length;

        int j;
        int cur;
        for (int move : moves) {
            j = move - 1;
            cur = 0;

            for (int i = 0; i < n; i++) {
                if (board[i][j] > 0) {
                    cur = board[i][j];
                    board[i][j] = 0;
                    break;
                }
            }

            if (cur > 0) {
                if (!stack.isEmpty() && stack.peek() == cur) {
                    stack.pop();
                    result += 2;
                } else {
                    stack.push(cur);
                }
            }
        }

        return result;
    }
}
