import java.util.*;

class Solution {
	int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;

		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0, 0, 1});
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int moveCnt = cur[2];

			if (x == n - 1 && y == m - 1) {
				return moveCnt;
			}

			for (int[] dir : dirs) {
				int nextX = x + dir[0];
				int nextY = y + dir[1];

				if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
					&& !visited[nextX][nextY] && maps[nextX][nextY] == 1
				) {
					visited[nextX][nextY] = true;
					queue.offer(new int[] {nextX, nextY, moveCnt + 1});
				}
			}
		}

		return -1;
	}
}