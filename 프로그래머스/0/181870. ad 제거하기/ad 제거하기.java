import java.util.*;

class Solution {
    static final String TARGET = "ad";

    public String[] solution(String[] strArr) {
        return Arrays.stream(strArr)
                .filter(str -> !str.contains(TARGET))
                .toArray(String[]::new);
    }
}