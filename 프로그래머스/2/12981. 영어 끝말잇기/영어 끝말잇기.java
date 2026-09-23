import java.util.*;

class Solution {
	public int[] solution(int n, String[] words) {
		Set<String> wordSet = new HashSet<>();
		wordSet.add(words[0]);

		for (int i = 1; i < words.length; i++) {
			if (!wordSet.add(words[i])
				|| words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)
			) {
				return new int[] {(i % n) + 1, (i + n) / n};
			}
		}

		return new int[] {0, 0};
	}
}