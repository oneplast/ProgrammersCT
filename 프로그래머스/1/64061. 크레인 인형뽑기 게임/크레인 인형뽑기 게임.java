import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int result = 0;
        List<Deque<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new ArrayDeque<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    list.get(j).offerLast(board[i][j]);
                }
            }
        }

        int idx;
        for (int i = 0; i < moves.length; i++) {
            idx = moves[i] - 1;

            if (list.get(idx).isEmpty()) {
                continue;
            }

            int cur = list.get(idx).pollFirst();

            if (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                result += 2;
            } else {
                stack.push(cur);
            }
        }

        return result;
    }
}