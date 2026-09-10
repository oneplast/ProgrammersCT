import java.util.stream.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] lowerS = s.toLowerCase().toCharArray();

        IntStream.range(0, lowerS.length)
                .forEach(i -> {
                    if (i == 0 || lowerS[i - 1] == ' ') {
                        sb.append(Character.toUpperCase(lowerS[i]));
                    } else {
                        sb.append(lowerS[i]);
                    }
                });

        return sb.toString();
    }
}