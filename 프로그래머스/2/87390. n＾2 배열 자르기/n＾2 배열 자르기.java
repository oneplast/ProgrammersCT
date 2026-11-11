class Solution {
	public int[] solution(int n, long left, long right) {
		int[] results = new int[(int) (right - left + 1)];

		for (int i = 0; i < results.length; i++) {
			long idx = left + i;

			int row = (int) (idx / n);
			int col = (int) (idx % n);

			results[i] = Math.max(row, col) + 1;
		}

		return results;
	}
}