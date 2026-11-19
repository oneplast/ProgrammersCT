import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        int[] sums = IntStream.range(0, num_list.length)
                .collect(
                        () -> new int[2],
                        (arr, i) -> arr[i % 2] += num_list[i],
                        (a, b) -> {
                            a[0] += b[0];
                            a[1] += b[1];
                        }
                );

        return Math.max(sums[0], sums[1]);
    }
}