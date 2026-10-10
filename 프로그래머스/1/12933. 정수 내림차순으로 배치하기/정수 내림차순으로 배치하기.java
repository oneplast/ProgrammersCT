import java.util.*;

class Solution {
    public long solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);

        return Long.parseLong(new StringBuilder(String.valueOf(chars))
                .reverse()
                .toString());
    }
}