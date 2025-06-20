class Solution {
    public int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    ++oCnt;
                } else if (board[i].charAt(j) == 'X') {
                    ++xCnt;
                }
            }
        }

        if (oCnt > xCnt + 1 || xCnt > oCnt) {
            return 0;
        }

        boolean caseOWin = isWin(board, 'O');
        boolean caseXWin = isWin(board, 'X');

        if (caseOWin && caseXWin) {
            return 0;
        }

        if (caseOWin && oCnt != xCnt + 1) {
            return 0;
        }

        if (caseXWin && oCnt != xCnt) {
            return 0;
        }

        return 1;
    }

    private boolean isWin(String[] board, char ch) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == ch && board[i].charAt(1) == ch && board[i].charAt(2) == ch) {
                return true;
            }

            if (board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch) {
                return true;
            }
        }

        if (board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch) {
            return true;
        }

        if (board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch) {
            return true;
        }

        return false;
    }
}