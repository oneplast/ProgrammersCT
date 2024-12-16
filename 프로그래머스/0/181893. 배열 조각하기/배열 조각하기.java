import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(arr).forEach(list::add);

        for (int i = 0; i < query.length; i++) {
            int idx = query[i];

            if (i % 2 == 0) {
                list = list.subList(0, idx + 1);
            } else {
                list = list.subList(idx, list.size());
            }
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}
