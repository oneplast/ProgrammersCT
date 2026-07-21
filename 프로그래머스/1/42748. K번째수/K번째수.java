import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        int resultIdx = 0;
        int startIdx, endIdx, destIdx;
        int[] tempArr;
        for (int[] command : commands) {
            startIdx = command[0] - 1;
            endIdx = command[1];
            destIdx = command[2] - 1;

            tempArr = Arrays.copyOfRange(array, startIdx, endIdx);
            Arrays.sort(tempArr);
            result[resultIdx++] = tempArr[destIdx];
        }

        return result;
    }
}
