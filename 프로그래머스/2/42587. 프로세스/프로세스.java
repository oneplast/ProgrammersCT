import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        IntStream.range(0, priorities.length)
                .forEach(i -> queue.offer(new int[]{priorities[i], i}));

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            boolean flag = queue.stream()
                    .anyMatch(data -> data[0] > cur[0]);

            if (flag) {
                queue.offer(cur);
            } else {
                cnt++;

                if (cur[1] == location) {
                    return cnt;
                }
            }
        }

        return -1;
    }
}