class Solution {
	public int[] solution(String s) {
		int[] results = new int[2];

		int preLen;
		int curLen;
		while (!s.equals("1")) {
			preLen = s.length();
			s = s.replace("0", "");
			curLen = s.length();
			s = Integer.toBinaryString(curLen);

			results[0]++;
			results[1] += preLen - curLen;
		}

		return results;
	}
}