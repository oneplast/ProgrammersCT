class Solution {

    int n;
    int m;
    int kBoardSize;

    public boolean solution(int[][] key, int[][] lock) {
        m = key.length;
        n = lock.length;
        kBoardSize = n + 2 * (m - 1);
        int loopSize = kBoardSize - m;

        for (int i = 0; i < 4; i++) {
            key = rotate(key);

            for (int j = -m + 1; j <= loopSize; j++) {
                for (int k = -m + 1; k <= loopSize; k++) {
                    if (checkValid(key, lock, j, k)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int[][] rotate(int[][] key) {
        int[][] rotatedKey = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotatedKey[i][j] = key[m - j - 1][i];
            }
        }

        return rotatedKey;
    }

    private boolean checkValid(int[][] key, int[][] lock, int row, int col) {
        int[][] newLock = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(lock[i], 0, newLock[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int lockRow = row + i;
                int lockCol = col + j;

                if (lockRow >= 0 && lockRow < n && lockCol >= 0 && lockCol < n) {
                    newLock[lockRow][lockCol] += key[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}