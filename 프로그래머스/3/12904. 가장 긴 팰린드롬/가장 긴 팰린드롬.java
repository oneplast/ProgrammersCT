import java.util.*;

class Solution {
    int max = 0;

    public int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, getPalindrome(s, i, i));
            max = Math.max(max, getPalindrome(s, i, i + 1));
        }

        return max;
    }

    private int getPalindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
