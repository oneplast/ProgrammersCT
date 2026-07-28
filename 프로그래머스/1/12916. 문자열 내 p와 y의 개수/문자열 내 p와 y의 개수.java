import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Solution {
    boolean solution(String s) {
        Map<String, Long> countMap = Arrays.stream(s.split(""))
			.map(String::toLowerCase)
			.filter(x -> x.equals("p") || x.equals("y"))
			.collect(Collectors.groupingBy(
				Function.identity(),
				Collectors.counting()
			));
		
		return countMap.getOrDefault("p", 0L) == countMap.getOrDefault("y", 0L);
    }
}