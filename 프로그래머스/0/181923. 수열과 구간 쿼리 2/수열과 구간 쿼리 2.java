import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int finalI = i;
            list.add(IntStream.range(0, arr.length)
                    .filter(x -> {
                        if (x >= queries[finalI][0] && x <= queries[finalI][1]) {
                            if (arr[x] > queries[finalI][2]) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .map(x -> arr[x])
                    .min().orElse(-1));
        }

        return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(x -> x).toArray();
    }
}
