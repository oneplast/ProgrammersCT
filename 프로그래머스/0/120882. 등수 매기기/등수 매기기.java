import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] result = new int[score.length];
        Arrays.fill(result, 1);

        double[] avgs = Arrays.stream(score)
                .mapToDouble(x -> (double) (x[0] + x[1]) / 2)
                .toArray();

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score.length; j++) {
                if (avgs[i] < avgs[j]) {
                    result[i]++;
                }
            }
        }

        return result;
    }
}
