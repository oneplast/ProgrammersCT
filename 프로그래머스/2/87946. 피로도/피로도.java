class Solution {
	boolean[] visited;
	int len;
	int result = 0;

	public int solution(int k, int[][] dungeons) {
		len = dungeons.length;
		visited = new boolean[len];

		dfs(dungeons, k, 0, 0);

		return result;
	}

	private void dfs(int[][] dungeons, int k, int depth, int candidate) {
		result = Math.max(result, candidate);

		if (depth >= len) {
			return;
		}

		for (int i = 0; i < len; i++) {
			if (!visited[i] && k >= dungeons[i][0]) {
				visited[i] = true;
				dfs(dungeons, k - dungeons[i][1], depth + 1, candidate + 1);
				visited[i] = false;
			}
		}
	}
}