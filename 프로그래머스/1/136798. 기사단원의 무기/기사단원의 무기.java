import java.util.stream.*;

class Solution {
	public int solution(int number, int limit, int power) {
		return IntStream.rangeClosed(1, number)
			.map(this::getDivisor)
			.map(atk -> atk > limit ? power : atk)
			.sum();

	}

	private int getDivisor(int num) {
		int divisorCnt = 0;
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				divisorCnt = i == num / i ? divisorCnt + 1 : divisorCnt + 2;
			}
		}

		return divisorCnt;
	}
}