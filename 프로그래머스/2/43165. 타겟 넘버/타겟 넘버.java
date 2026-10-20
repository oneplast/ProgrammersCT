import java.util.*;

class Solution {
	public int solution(int[] numbers, int target) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(0);

		for (int number : numbers) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int value = queue.poll();

				queue.offer(value + number);
				queue.offer(value - number);
			}
		}

		int result = 0;
		while (!queue.isEmpty()) {
			if (queue.poll() == target) {
				result++;
			}
		}

		return result;
	}
}