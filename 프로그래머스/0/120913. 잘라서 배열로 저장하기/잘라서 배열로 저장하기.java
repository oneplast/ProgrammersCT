import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<>();
        int startIdx = 0;

        while (startIdx < my_str.length()) {
            if (startIdx + n >= my_str.length()) {
                list.add(my_str.substring(startIdx));
                break;
            }

            list.add(my_str.substring(startIdx, startIdx + n));
            startIdx += n;
        }

        return list.stream().toArray(String[]::new);
    }
}