import java.util.*;

class Solution {

    private int[][] brackets;

    public int solution(int n) {
        brackets = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(brackets[i], -1);
        }

        return dfs(n, n);
    }

    private int dfs(int openRemain, int closeRemain) {
        if (openRemain == 0 && closeRemain == 0) {
            return 1;
        }

        if (brackets[openRemain][closeRemain] != -1) {
            return brackets[openRemain][closeRemain];
        }

        int cnt = 0;

        if (openRemain > 0) {
            cnt += dfs(openRemain - 1, closeRemain);
        }

        if (closeRemain > openRemain) {
            cnt += dfs(openRemain, closeRemain - 1);
        }

        return brackets[openRemain][closeRemain] = cnt;
    }
}