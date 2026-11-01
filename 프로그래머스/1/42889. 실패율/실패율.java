import java.util.*;

class Solution {
	public int[] solution(int N, int[] stages) {
		int[] failStage = new int[N + 2];
		Arrays.stream(stages).forEach(i -> failStage[i]++);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (failRate(a[1], a[2]) == failRate(b[1], b[2])) {
				return Integer.compare(a[0], b[0]);
			} else {
				return Float.compare(failRate(b[1], b[2]), failRate(a[1], a[2]));
			}
		});

		int remainTotal = stages.length;
		for (int i = 1; i <= N; i++) {
			pq.offer(new int[] {i, failStage[i], remainTotal});
			remainTotal -= failStage[i];
		}

		return pq.stream().sorted(pq.comparator()).mapToInt(i -> i[0]).toArray();
	}

	private float failRate(int failCnt, int total) {
		return total == 0 ? 0 : (float) failCnt / total;
	}
}