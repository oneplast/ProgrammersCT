class Solution {
    String[] candidates = {"A", "E", "I", "O", "U"};
    int cnt = 0;
    int result;

    public int solution(String word) {
        dfs(new StringBuilder(), word);

        return result;
    }

    private void dfs(StringBuilder sb, String word) {
        if (sb.toString().equals(word)) {
            result = cnt;
            return;
        }

        if (sb.length() >= candidates.length) {
            return;
        }

        for (String candidate : candidates) {
            cnt++;
            dfs(sb.append(candidate), word);
            sb.deleteCharAt(sb.length() - 1);

            if (result > 0) {
                return;
            }
        }
    }
}