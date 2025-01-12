class Solution {
    int result;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        result = Integer.MIN_VALUE;
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, 0);

        return result;
    }

    public void dfs(int k, int[][] dungeons, int depth, int count) {
        if (depth == dungeons.length) {
            result = Math.max(result, count);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                if (k >= dungeons[i][0]) {
                    k -= dungeons[i][1];
                    visited[i] = true;
                    dfs(k, dungeons, depth + 1, count + 1);
                    visited[i] = false;
                    k += dungeons[i][1];
                }
            }
        }

        result = Math.max(result, count);
    }
}