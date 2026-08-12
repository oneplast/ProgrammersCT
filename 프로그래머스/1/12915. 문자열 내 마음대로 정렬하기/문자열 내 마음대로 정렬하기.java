import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
			.sorted((a, b) -> {
				char charA = a.charAt(n);
				char charB = b.charAt(n);

				return charA == charB ? a.compareTo(b) : charA - charB;
			})
			.toArray(String[]::new);
    }
}