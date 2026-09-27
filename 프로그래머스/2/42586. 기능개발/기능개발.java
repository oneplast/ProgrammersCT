import java.util.*;

class Solution {
    static final int LIMIT = 100;

    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();
        int deployDay = 0;
        int size = progresses.length;

        for (int i = 0; i < size; i++) {
            int cur = progresses[i];
            int speed = speeds[i];

            int need = LIMIT - cur;
            int progressDay = (need % speed) == 0 ? need / speed : (need / speed) + 1;

            if (progressDay > deployDay) {
                deployDay = progressDay;
                deque.offerLast(1);
            } else {
                int before = deque.pollLast();
                deque.offerLast(before + 1);
            }
        }

        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}