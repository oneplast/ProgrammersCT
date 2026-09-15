import java.util.stream.*;

class Solution {
	public int solution(int[] a, int[] b) {
		return IntStream.range(0, a.length)
			.reduce(0, (x, i) -> x + a[i] * b[i]);
	}
}