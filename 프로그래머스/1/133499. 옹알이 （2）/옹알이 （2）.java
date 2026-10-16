import java.util.*;

class Solution {
	public int solution(String[] babbling) {
		Set<String> announceSet = new HashSet<>(Arrays.asList("aya", "ye", "woo", "ma"));

		int result = 0;
		for (String word : babbling) {
			String prevAnnounce = "";

			boolean breakFlag = false;
			while (!word.isEmpty() && !breakFlag) {
				for (String announce : announceSet) {
					if (word.startsWith(announce) && !prevAnnounce.equals(announce)) {
						word = word.substring(announce.length());
						prevAnnounce = announce;
						breakFlag = false;
						break;
					} else {
						breakFlag = true;
					}
				}
			}

			if (word.isEmpty()) {
				result++;
			}
		}

		return result;
	}
}