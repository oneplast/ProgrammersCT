import java.util.*;

class Solution {
    int result;

    public int solution(String word) {
        result = 0;

        List<Character> words = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        StringBuilder sb = new StringBuilder();

        dfs(word, sb, words);

        return result;
    }

    public boolean dfs(String word, StringBuilder sb, List<Character> words) {
        if (sb.toString().equals(word)) {
            return true;
        }

        if (sb.length() >= 5) {
            return false;
        }

        for (char c : words) {
            sb.append(c);
            result++;
            if (dfs(word, sb, words)) {
                return true;
            }

            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }
}
