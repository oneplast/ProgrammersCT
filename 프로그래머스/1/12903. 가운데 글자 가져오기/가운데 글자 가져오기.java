class Solution {
    public String solution(String s) {
        int halfIdx = s.length() / 2;

        return s.length() % 2 == 0
                ? s.substring(halfIdx - 1, halfIdx + 1)
                : String.valueOf(s.charAt(halfIdx));
    }
}
