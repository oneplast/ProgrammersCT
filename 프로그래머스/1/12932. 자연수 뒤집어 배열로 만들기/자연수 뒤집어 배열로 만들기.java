import java.util.stream.*;

class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);

        return IntStream.range(0, str.length())
                .map(i -> str.charAt(str.length() - 1 - i) - '0')
                .toArray();
    }
}