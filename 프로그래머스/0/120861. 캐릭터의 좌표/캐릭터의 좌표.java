class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = board[0] / 2;
        int y = board[1] / 2;
        int[] newBoard = new int[board.length];

        for (int i = 0; i < keyinput.length; i++) {
            String key = keyinput[i];
            if (key.equals("left") && newBoard[0] - 1 >= -x) {
                newBoard[0] -= 1;
            }

            else if (key.equals("right") && newBoard[0] + 1 <= x) {
                newBoard[0] += 1;
            }

            else if (key.equals("up") && newBoard[1] + 1 <= y) {
                newBoard[1] += 1;
            }

            else if (key.equals("down") && newBoard[1] - 1 >= -y) {
                newBoard[1] -= 1;
            }
        }

        return newBoard;
    }
}
