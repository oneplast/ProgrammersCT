import java.util.*;

class Solution {
	public int[] solution(int n) {
		List<Integer> results = new ArrayList<>();
		while (n != 1) {
			results.add(n);
			n = n % 2 == 0 ? n / 2 : 3 * n + 1;

			if (n == 1) {
				results.add(1);
			}
		}

		return results.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}