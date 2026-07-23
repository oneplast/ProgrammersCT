import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        int size = nums.length / 2;

        int numsKeySize = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(
                        key -> key,
                        value -> 1,
                        Integer::sum
                ))
                .keySet().size();

        return Math.min(numsKeySize, size);
    }
}
