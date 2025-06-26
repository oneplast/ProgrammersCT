import java.util.*;

class Solution {
    int result = 0;

    public int solution(int n, int[][] q, int[] ans) {
        dfs(new ArrayList<>(), q, ans, n, 1);
        return result;
    }

    private void dfs(List<Integer> visited, int[][] q, int[] ans, int n, int start) {
        if (visited.size() == 5) {
            if (isPossible(visited, q, ans)) {
                ++result;
            }

            return;
        }

        for (int i = start; i <= n; i++) {
            visited.add(i);
            dfs(visited, q, ans, n, i + 1);
            visited.remove(visited.size() - 1);
        }
    }

    private boolean isPossible(List<Integer> visited, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int data : q[i]) {
                if (visited.contains(data)) {
                    ++cnt;
                }
            }

            if (cnt != ans[i]) {
                return false;
            }
        }

        return true;
    }
}