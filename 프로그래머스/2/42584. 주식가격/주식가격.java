import java.util.*;

class Solution {
	private Stack<Integer> stack = new Stack<>();
	private int[] results;

	public int[] solution(int[] prices) {
		results = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				calculateStock(i);
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			calculateStock(prices.length - 1);
		}

		return results;
	}

	private void calculateStock(int curIdx) {
		int idx = stack.pop();
		results[idx] = curIdx - idx;
	}
}