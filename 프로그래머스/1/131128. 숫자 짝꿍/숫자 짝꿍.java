import java.util.*;
import java.util.stream.*;

class Solution {
	public String solution(String X, String Y) {
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> commonMap = new HashMap<>();

		for (String x : X.split("")) {
			commonMap.put(x, commonMap.getOrDefault(x, 0) + 1);
		}

		for (String y : Y.split("")) {
			if (commonMap.containsKey(y) && commonMap.get(y) > 0) {
				sb.append(y);
				commonMap.put(y, commonMap.get(y) - 1);
			}
		}

		if (sb.toString().startsWith("0")) {
			return "0";
		}

		return sb.toString().isEmpty()
			? "-1"
			: Arrays.stream(sb.toString().split("")).sorted(Comparator.reverseOrder())
			.collect(Collectors.joining());
	}
}