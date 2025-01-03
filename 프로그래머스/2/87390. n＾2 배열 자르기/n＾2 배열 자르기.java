import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Long> list = new ArrayList<>();

        while (left <= right) {
            long N = left / n;
            long M = left % n;

            long result;

            if (N >= M) {
                result = N + 1;
            } else {
                result = M + 1;
            }

            list.add(result);
            left++;
        }

        return list.stream().mapToInt(Long::intValue).toArray();
    }
}