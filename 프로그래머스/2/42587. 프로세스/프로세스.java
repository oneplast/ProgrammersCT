import java.util.*;

class Solution {
	static final int MAX = 9;

	public int solution(int[] priorities, int location) {
		Queue<int[]> queue = new ArrayDeque<>();
		int[] counts = new int[MAX + 1];

		for (int i = 0; i < priorities.length; i++) {
			queue.offer(new int[] {priorities[i], i});
			counts[priorities[i]]++;
		}

		int cnt = 0;
		int max = MAX;
		while (!queue.isEmpty()) {
			while (counts[max] == 0) {
				max--;
			}

			int[] cur = queue.poll();
			int num = cur[0];
			int idx = cur[1];

			if (max > num) {
				queue.offer(cur);
			} else {
				cnt++;
				counts[num]--;

				if (idx == location) {
					return cnt;
				}
			}
		}

		return -1;
	}
}