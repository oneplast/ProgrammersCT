class Solution {
    public int solution(int n, int w, int num) {
        int row = (int) Math.ceil((double) n / w);
        int[][] arr = new int[row + 1][w + 1];

        int box = 1;
        for (int i = 1; i <= row; i++) {
            if (i % 2 != 0) {
                for (int j = 1; j <= w && box <= n; j++) {
                    arr[i][j] = box++;
                }
            } else {
                for (int j = w; j > 0 && box <= n; j--) {
                    arr[i][j] = box++;
                }
            }
        }

        int targetRow = 0;
        int targetCol = 0;

        loop:
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= w; j++) {
                if (arr[i][j] == num) {
                    targetRow = i;
                    targetCol = j;
                    break loop;
                }
            }
        }

        int result = 0;
        for (int i = targetRow; i <= row; i++) {
            if (arr[i][targetCol] != 0) {
                ++result;
            }
        }

        return result;
    }
}