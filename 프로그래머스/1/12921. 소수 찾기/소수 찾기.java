class Solution {
	public int solution(int n) {
		int result = 0;
		boolean isPrime;
		for (int i = 2; i <= n; i++) {
			isPrime = true;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				result++;
			}
		}

		return result;
	}
}