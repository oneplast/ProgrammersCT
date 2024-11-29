import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        int startIdx = -1;
        int minIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (startIdx == -1 && arr[i] == 2) {
                startIdx = i;
                minIdx = i;
                continue;
            }

            if (arr[i] == 2) {
                minIdx = i;
            }
        }

        return startIdx == -1 ? new int[]{startIdx} : IntStream.rangeClosed(startIdx, minIdx).map(i -> arr[i]).toArray();
    }
}