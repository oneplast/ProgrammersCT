import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        long target = (sum1 + sum2) / 2;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        int cnt = 0;
        while (cnt < queue1.length * 3 && (!q1.isEmpty() && !q2.isEmpty())) {
            if (sum1 > target) {
                int poll = q1.poll();
                q2.offer(poll);
                sum1 -= poll;
                sum2 += poll;
                answer++;
            } else if (sum2 > target) {
                int poll = q2.poll();
                q1.offer(poll);
                sum1 += poll;
                sum2 -= poll;
                answer++;
            }
            
            cnt++;
            if (sum1 == target && sum2 == target) {
                return answer;
            }
        }

        return -1;
    }
}
