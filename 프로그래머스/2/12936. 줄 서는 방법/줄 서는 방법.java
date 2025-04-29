import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }

        k--;

        for (int i = 0; i < n; i++) {
            int val = (int) (k / dp[n - 1 - i]);
            answer[i] = list.remove(val);
            k %= dp[n - 1 - i];
        }

        return answer;
    }
}
