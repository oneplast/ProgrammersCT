class Solution {
	boolean[] composited = new boolean[3001];

	public int solution(int[] nums) {
		fillComposite();

		int cur;
		int result = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				for (int k = j + 1; k < len; k++) {
					cur = nums[i] + nums[j] + nums[k];
					if (!composited[cur]) {
						result++;
					}
				}
			}
		}

		return result;
	}

	private void fillComposite() {
		int n = 3000;

		for (int i = 2; i * i <= n; i++) {
			if (composited[i]) {
				continue;
			}

			for (int j = i * i; j <= n; j += i) {
				composited[j] = true;
			}
		}
	}
}