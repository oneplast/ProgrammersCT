import java.util.*;

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int solution(int[][] board) {
        int n = board.length;
        int[][] newBoard = new int[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (board[j][i] == 1) {
                    newBoard[j][i] = 1;
                    for (int[] dir : dirs) {
                        int newJ = j + dir[0];
                        int newI = i + dir[1];
                        if (newJ >= 0 && newJ < n && newI >= 0 && newI < n) {
                            newBoard[newJ][newI] = 1;
                        }
                    }
                }
            }
        }

        return (int) Arrays.stream(newBoard)
                .flatMapToInt(Arrays::stream)
                .filter(x -> x == 0)
                .count();
    }
}