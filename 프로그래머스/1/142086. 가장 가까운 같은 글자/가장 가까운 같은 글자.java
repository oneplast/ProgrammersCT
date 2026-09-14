import java.util.*;

class Solution {
	public int[] solution(String s) {
		Map<String, Integer> map = new HashMap<>();
		int[] results = new int[s.length()];

		int curIdx = 0;
		for (String key : s.split("")) {
			if (!map.containsKey(key)) {
				map.put(key, curIdx);
				results[curIdx] = -1;
			} else {
				results[curIdx] = curIdx - map.get(key);
				map.put(key, curIdx);
			}

			curIdx++;
		}

		return results;
	}
}