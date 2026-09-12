class Solution {
    public int solution(String t, String p) {
        int result = 0;
        int len = p.length();

        String candidate;
        for (int i = 0; i <= t.length() - len; i++) {
            candidate = t.substring(i, i + len);

            result = candidate.compareTo(p) <= 0 ? result + 1 : result;
        }

        return result;
    }
}