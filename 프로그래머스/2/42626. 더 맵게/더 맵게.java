import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));

        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while (!pq.isEmpty()) {
            int min1 = pq.poll();

            if (min1 >= K) {
                break;
            }

            if (pq.isEmpty()) {
                return -1;
            }

            int min2 = pq.poll();

            pq.offer(min1 + (min2 * 2));
            answer++;
        }

        return answer;
    }
}