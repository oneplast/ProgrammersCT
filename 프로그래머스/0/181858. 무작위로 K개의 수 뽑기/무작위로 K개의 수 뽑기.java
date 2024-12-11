import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(arr).boxed().distinct().filter(x -> list.size() < k).forEach(list::add);

        while (list.size() < k) list.add(-1);

        return list.stream().mapToInt(x -> x).toArray();
    }
}
