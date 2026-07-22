import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        Collections.addAll(pq, strNumbers);

        String result = Stream.generate(pq::poll).limit(pq.size()).collect(Collectors.joining());

        return result.startsWith("0") ? "0" : result;
    }
}