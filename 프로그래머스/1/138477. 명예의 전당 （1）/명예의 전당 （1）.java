import java.util.*;

class Solution {
	public int[] solution(int k, int[] score) {
		int[] results = new int[score.length];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());

		int curIdx = 0;
		for (int scoreOfDay : score) {
			if (pq.size() < k) {
				pq.offer(scoreOfDay);
			} else {
				if (pq.peek() < scoreOfDay) {
					pq.poll();
					pq.offer(scoreOfDay);
				}
			}

			results[curIdx++] = pq.peek();
		}

		return results;
	}
}