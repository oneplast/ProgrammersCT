import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Integer[] newMats = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(newMats, Collections.reverseOrder());

        int row = park.length;
        int col = park[0].length;

        for (int newMat : newMats) {
            if (isPossible(park, row, col, newMat)) {
                return newMat;
            }
        }

        return -1;
    }

    private boolean isPossible(String[][] park, int row, int col, int size) {
        for (int i = 0; i <= row - size; i++) {
            for (int j = 0; j <= col - size; j++) {
                if (isValid(park, j, i, size)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(String[][] park, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!park[j][i].equals("-1")) {
                    return false;
                }
            }
        }

        return true;
    }
}