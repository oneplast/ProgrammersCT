import java.util.stream.*;

class Solution {
	boolean[] isComposite;

	public int solution(int n) {
		isComposite = new boolean[n + 1];

		judgePrime(n);

		return IntStream.rangeClosed(2, n)
			.filter(i -> !isComposite[i])
			.map(i -> 1)
			.sum();
	}

	private void judgePrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (!isComposite[i]) {
				for (int j = i * i; j <= num; j += i) {
					isComposite[j] = true;
				}
			}
		}
	}
}