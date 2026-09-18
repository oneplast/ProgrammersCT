import java.util.*;

class Solution {
	public int solution(int n) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {n, 0});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curN = cur[0];
			int dist = cur[1];

			if (curN == 0) {
				return dist;
			}

			queue.offer(curN % 2 == 0 ? new int[] {curN / 2, dist} : new int[] {curN - 1, dist + 1});
		}

		return -1;
	}
}