import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();

        int curIdx = 0;
        while (curIdx < arr.length) {
            int cur = arr[curIdx++];
            deque.add(cur);

            while (curIdx < arr.length && cur == arr[curIdx]) {
                curIdx++;
            }
        }

        return deque.stream().mapToInt(Integer::valueOf).toArray();
    }
}