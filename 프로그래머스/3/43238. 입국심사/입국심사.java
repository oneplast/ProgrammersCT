import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long result = Long.MAX_VALUE;
        int len = times.length;
        Arrays.sort(times);

        long left = times[0];
        long right = (long) times[len - 1] * n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long total = 0;

            for (int time : times) {
                total += mid / time;
            }

            if (total >= n) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}