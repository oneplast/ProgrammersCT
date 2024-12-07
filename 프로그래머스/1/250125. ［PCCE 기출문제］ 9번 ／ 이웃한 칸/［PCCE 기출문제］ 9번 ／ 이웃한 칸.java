class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int N = board.length - 1;

        if (w > 0) {
            if (board[h][w - 1].equals(board[h][w])) {
                answer += 1;
            }
        }

        if (w < N) {
            if (board[h][w + 1].equals(board[h][w])) {
                answer += 1;
            }
        }

        if (h > 0) {
            if (board[h - 1][w].equals(board[h][w])) {
                answer += 1;
            }
        }

        if (h < N) {
            if (board[h + 1][w].equals(board[h][w])) {
                answer += 1;
            }
        }

        return answer;
    }
}