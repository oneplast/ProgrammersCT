import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            int level = left + (right - left) / 2;
            long totalTime = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= level) {
                    totalTime += times[i];
                } else {
                    totalTime += ((long) (diffs[i] - level) * (times[i] + times[i - 1]) + times[i]);
                }
            }

            if (totalTime > limit) {
                left = level + 1;
            } else {
                result = Math.min(result, level);
                right = level - 1;
            }
        }

        return result;
    }
}