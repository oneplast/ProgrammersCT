import java.util.regex.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        Matcher matcher = Pattern.compile("\\s+|\\S+").matcher(s);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String word = matcher.group();

            if (word.startsWith(" ")) {
                sb.append(word);
            } else {
                sb.append(
                        IntStream.range(0, word.length())
                                .mapToObj(i -> i % 2 == 0
                                        ? String.valueOf(Character.toUpperCase(word.charAt(i)))
                                        : String.valueOf(Character.toLowerCase(word.charAt(i))))
                                .collect(Collectors.joining()));
            }
        }

        return sb.toString();
    }
}