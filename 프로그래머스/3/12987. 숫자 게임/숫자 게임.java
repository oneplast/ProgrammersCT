import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int result = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int n = B.length;
        int idx = 0;
        for (int a : A) {
            while (idx < n && B[idx] <= a) {
                idx++;
            }

            if (idx >= n) {
                break;
            }

            idx++;
            result++;
        }

        return result;
    }
}