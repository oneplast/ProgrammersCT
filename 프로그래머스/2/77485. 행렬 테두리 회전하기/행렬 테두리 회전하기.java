import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows + 1][columns + 1];

        int matrixData = 0;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                matrix[i][j] = ++matrixData;
            }
        }

        int idx = 0;
        for (int[] query : queries) {
            int rowStartIdx = query[0];
            int rowEndIdx = query[2];
            int colStartIdx = query[1];
            int colEndIdx = query[3];
            int min = Integer.MAX_VALUE;

            int curNum;
            int beforeNum = matrix[rowStartIdx + 1][colStartIdx];
            for (int i = colStartIdx; i <= colEndIdx; i++) {
                curNum = matrix[rowStartIdx][i];
                matrix[rowStartIdx][i] = beforeNum;
                beforeNum = curNum;
                min = Math.min(min, curNum);
            }

            for (int i = rowStartIdx + 1; i <= rowEndIdx; i++) {
                curNum = matrix[i][colEndIdx];
                matrix[i][colEndIdx] = beforeNum;
                beforeNum = curNum;
                min = Math.min(min, curNum);
            }

            for (int i = colEndIdx - 1; i >= colStartIdx; i--) {
                curNum = matrix[rowEndIdx][i];
                matrix[rowEndIdx][i] = beforeNum;
                beforeNum = curNum;
                min = Math.min(min, curNum);
            }

            for (int i = rowEndIdx - 1; i >= rowStartIdx; i--) {
                curNum = matrix[i][colStartIdx];
                matrix[i][colStartIdx] = beforeNum;
                beforeNum = curNum;
                min = Math.min(min, curNum);
            }

            answer[idx++] = min;
        }

        return answer;
    }
}
