import java.util.*;

class Solution {
    public String solution(String s) {
        int[] intS = Arrays.stream(s.split(" "))
			.map(Integer::parseInt)
			.mapToInt(Integer::intValue)
			.toArray();
        
        return new StringBuilder().append(Arrays.stream(intS).min().getAsInt())
            .append(" ")
            .append(Arrays.stream(intS).max().getAsInt())
            .toString();
    }
}