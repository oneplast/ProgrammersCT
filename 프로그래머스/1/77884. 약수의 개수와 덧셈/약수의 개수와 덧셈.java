class Solution {
	public int solution(int left, int right) {
		int result = 0;

		while (left <= right) {
			result = isOdd(left) ? result - left : result + left;
			left++;
		}

		return result;
	}

	private boolean isOdd(int num) {
		return num % Math.sqrt(num) == 0;
	}
}