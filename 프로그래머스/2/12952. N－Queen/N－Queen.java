class Solution {
    int result = 0;
    int[] board;

    public int solution(int n) {
        board = new int[n];
        nQueen(n, 0);

        return result;
    }

    private void nQueen(int n, int depth) {
        if (depth == n) {
            ++result;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[depth] = i;

            if (isPossible(depth)) {
                nQueen(n, depth + 1);
            }
        }
    }

    private boolean isPossible(int n) {
        for (int i = 0; i < n; i++) {
            if (board[n] == board[i] || (n - i) == Math.abs(board[n] - board[i])) {
                return false;
            }
        }

        return true;
    }
}