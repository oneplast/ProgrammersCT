import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }

        Deque<String> deq = new ArrayDeque<>(Arrays.asList(A.split("")));

        int cnt = 0;
        while (cnt < A.length()) {
            String data = deq.pollLast();
            deq.offerFirst(data);
            cnt++;

            if (deq.stream().collect(Collectors.joining()).equals(B)) {
                return cnt;
            }
        }

        return -1;
    }
}
