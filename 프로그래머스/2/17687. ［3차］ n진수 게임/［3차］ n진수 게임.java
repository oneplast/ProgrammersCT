class Solution {
	public String solution(int n, int t, int m, int p) {
		StringBuilder dpSb = new StringBuilder();

		for (int i = 0; i <= t * m; i++) {
			dpSb.append(Integer.toString(i, n).toUpperCase());
		}

		String[] dpBits = dpSb.toString().split("");
		StringBuilder resultSb = new StringBuilder();

		int startIdx = p - 1;
		int loopCnt = 0;
		while (loopCnt < t) {
			resultSb.append(dpBits[startIdx]);
			startIdx += m;
			loopCnt++;
		}

		return resultSb.toString();
	}
}