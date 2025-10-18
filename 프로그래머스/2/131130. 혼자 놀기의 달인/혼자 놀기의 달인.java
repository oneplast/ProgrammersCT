import java.util.*;

class Solution {

    int n;
    boolean[] visited;
    List<Integer> groups;

    public int solution(int[] cards) {
        n = cards.length;
        visited = new boolean[n];
        groups = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int groupCnt = 0;
            int value = dfs(cards, i, groupCnt);
            if (value > 0) {
                groups.add(value);
            }
        }

        if (groups.size() < 2) {
            return 0;
        }

        groups.sort(Collections.reverseOrder());

        return groups.get(0) * groups.get(1);
    }

    private int dfs(int[] cards, int idx, int groupCnt) {
        if (visited[idx]) {
            return groupCnt;
        }

        visited[idx] = true;
        int nextIdx = cards[idx] - 1;
        return dfs(cards, nextIdx, groupCnt + 1);
    }
}