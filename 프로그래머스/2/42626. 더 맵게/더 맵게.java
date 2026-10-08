import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));

		Arrays.stream(scoville).forEach(pq::offer);

		int cnt = 0;
		while (!pq.isEmpty()) {
			int cur = pq.poll();

			if (cur >= K) {
				return cnt;
			}

			if (pq.isEmpty()) {
				return -1;
			}
			
			pq.offer(cur + (pq.poll() * 2));
			cnt++;
		}

		return cnt;
	}
}