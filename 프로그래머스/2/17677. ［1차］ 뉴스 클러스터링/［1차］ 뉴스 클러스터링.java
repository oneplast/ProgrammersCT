import java.util.*;

class Solution {
	private static final int MULTIPLE = 65536;

	public int solution(String str1, String str2) {
		Map<String, Integer> countMap1 = new HashMap<>();
		Map<String, Integer> countMap2 = new HashMap<>();
		fillMap(countMap1, str1);
		fillMap(countMap2, str2);

		int intersectionCnt = 0;
		for (String key1 : countMap1.keySet()) {
			if (countMap2.containsKey(key1)) {
				intersectionCnt += Math.min(countMap1.get(key1), countMap2.get(key1));
			}
		}
		int unionCnt = getUnionCnt(countMap1) + getUnionCnt(countMap2) - intersectionCnt;

		if (unionCnt == 0) {
			return MULTIPLE;
		}

		return getJaccard(intersectionCnt, unionCnt);
	}

	private void fillMap(Map<String, Integer> map, String str) {
		String key;
		for (int i = 0; i < str.length() - 1; i++) {
			key = str.substring(i, i + 2);

			if (key.matches("[a-zA-Z]{2}")) {
				key = key.toLowerCase();
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
		}
	}

	private int getUnionCnt(Map<String, Integer> map) {
		return map.values().stream().reduce(0, Integer::sum);
	}

	private int getJaccard(int intersectionCnt, int unionCnt) {
		return (int) (((float) intersectionCnt / unionCnt) * MULTIPLE);
	}
}