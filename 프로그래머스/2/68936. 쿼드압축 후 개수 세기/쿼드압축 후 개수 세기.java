class Solution {
    int[] result = new int[2];

    public int[] solution(int[][] arr) {
        calculate(arr, 0, 0, arr.length);
        return result;
    }

    private void calculate(int[][] arr, int x, int y, int n) {
        int num = arr[y][x];
        boolean isPossible = true;

        loop:
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (arr[i][j] != num) {
                    isPossible = false;
                    break loop;
                }
            }
        }

        if (isPossible) {
            if (num == 0) {
                ++result[0];
            } else {
                ++result[1];
            }
        } else {
            int halfN = n / 2;
            calculate(arr, x, y, halfN);
            calculate(arr, x + halfN, y, halfN);
            calculate(arr, x, y + halfN, halfN);
            calculate(arr, x + halfN, y + halfN, halfN);
        }
    }
}