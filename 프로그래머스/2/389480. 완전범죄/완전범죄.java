import java.util.*;

class Solution {

    final int INF = Integer.MAX_VALUE;

    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < info.length; i++) {
            int a = info[i][0];
            int b = info[i][1];

            int[] newDp = new int[m];
            Arrays.fill(newDp, INF);

            for (int bCnt = 0; bCnt < m; bCnt++) {
                if (dp[bCnt] == INF) {
                    continue;
                }

                newDp[bCnt] = Math.min(newDp[bCnt], dp[bCnt] + a);

                int caseB = bCnt + b;
                if (caseB < m) {
                    newDp[caseB] = Math.min(newDp[caseB], dp[bCnt]);
                }
            }

            dp = newDp;
        }

        int result = INF;
        for (int bCnt = 0; bCnt < m; bCnt++) {
            if (dp[bCnt] < n) {
                result = Math.min(dp[bCnt], result);
            }
        }

        return result != INF ? result : -1;
    }
}