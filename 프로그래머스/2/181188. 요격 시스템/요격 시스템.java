import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int[][] sortedArr = Arrays.stream(targets)
                .sorted((a, b) -> a[1] - b[1])
                .toArray(int[][]::new);

        int curValue = -1;
        for (int[] target : sortedArr) {
            int s = target[0];
            int e = target[1];

            if (curValue <= s) {
                ++answer;
                curValue = e;
            }
        }

        return answer;
    }
}
