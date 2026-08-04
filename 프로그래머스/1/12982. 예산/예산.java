import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int result = 0;

        Arrays.sort(d);

        int left = 0;
        int right, cnt, sum;
        while (left < d.length) {
            if ((result != 0 && d.length - left < result) || d[left] > budget) {
                return result;
            }

            sum = d[left];
            right = ++left;
            cnt = 1;

            while (right < d.length && sum + d[right] <= budget) {
                sum += d[right++];
                cnt++;
            }

            result = Math.max(result, cnt);
        }

        return result;
    }
}