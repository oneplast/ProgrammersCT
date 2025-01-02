import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int n = elements.length;
        int r = 0;
        while (r < n) {
            int start = 0;

            while (start < n) {
                set.add(IntStream.rangeClosed(start, start + r)
                        .map(x -> {
                            if (x >= n) {
                                x %= n;
                            }
                            return x;
                        })
                        .map(x -> elements[x])
                        .sum());
                start++;
            }

            r++;
        }

        return set.size();
    }
}