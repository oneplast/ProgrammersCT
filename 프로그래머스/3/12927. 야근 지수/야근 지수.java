import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Arrays.sort(works);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(works).forEach(pq::offer);

        int cnt = 0;
        while (cnt < n && !pq.isEmpty()) {
            int cur = pq.poll();

            cnt++;
            if (cur != 0) {
                pq.offer(cur - 1);
            }
        }

        if (pq.isEmpty() && cnt < n) {
            return 0;
        }

        return pq.stream().mapToLong(x -> (long) Math.pow(x, 2)).reduce(Long::sum).getAsLong();
    }
}