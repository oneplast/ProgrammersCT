class Solution {
    public int solution(int m, int n, String[] board) {
        int result = 0;
        String[][] newBoard = new String[m][n];

        for (int i = 0; i < board.length; i++) {
            String[] splitBits = board[i].split("");
            System.arraycopy(splitBits, 0, newBoard[i], 0, board[i].length());
        }

        boolean[][] booleanBoard;
        int cnt;
        while (true) {
            booleanBoard = new boolean[m][n];
            cnt = countDrop(booleanBoard, newBoard, m, n);

            if (cnt == 0) {
                break;
            }

            dropLine(booleanBoard, newBoard, m, n);
            result += cnt;
        }

        return result;
    }

    private int countDrop(boolean[][] booleanBoard, String[][] newBoard, int m, int n) {
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!newBoard[i][j].isEmpty()
                        && (j + 1 < n && newBoard[i][j + 1].equals(newBoard[i][j]))
                        && (i + 1 < m && newBoard[i + 1][j].equals(newBoard[i][j]))
                        && (i + 1 < m && j + 1 < n && newBoard[i + 1][j + 1].equals(newBoard[i][j]))) {
                    booleanBoard[i][j] = true;
                    booleanBoard[i + 1][j] = true;
                    booleanBoard[i][j + 1] = true;
                    booleanBoard[i + 1][j + 1] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (booleanBoard[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dropLine(boolean[][] booleanBoard, String[][] newBoard, int m, int n) {
        int row = 0;
        while (row < n) {
            for (int i = 1; i < m; i++) {
                if (booleanBoard[i][row]) {
                    int idx = i;
                    while (idx > 0) {
                        newBoard[idx][row] = newBoard[idx - 1][row];
                        newBoard[idx - 1][row] = "";
                        idx--;
                    }
                }
            }

            row++;
        }
    }
}
