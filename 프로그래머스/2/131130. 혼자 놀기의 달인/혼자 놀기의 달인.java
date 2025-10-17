import java.util.*;

class Solution {

    int n;
    int[] dp;
    List<Integer> groups;

    public int solution(int[] cards) {
        n = cards.length;
        dp = new int[n];
        groups = new ArrayList<>();
        Arrays.fill(dp, 1);

        int group = -1;
        int groupIdx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] < 0) {
                continue;
            }

            dp[i] = group;
            groups.add(1);

            int nextIdx = cards[i] - 1;
            while (dp[nextIdx] != group) {
                dp[nextIdx] = group;
                groups.set(groupIdx, groups.get(groupIdx) + 1);
                int curVal = cards[nextIdx];
                nextIdx = curVal - 1;
            }

            --group;
            ++groupIdx;
        }

        if (group >= -2) {
            return 0;
        }

        groups.sort((a, b) -> b - a);

        return groups.get(0) * groups.get(1);
    }
}