import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;

        Map<Integer, Integer> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(
                        num -> num,
                        num -> 1,
                        Integer::sum
                ));

        int max = map.keySet().size();

        return Math.min(max, answer);
    }
}