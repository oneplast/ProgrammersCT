import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int len = enemy.length;

        if (k >= len) {
            return len;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;

        for (int i = 0; i < len; i++) {
            int curEnemy = enemy[i];
            pq.offer(curEnemy);
            sum += curEnemy;

            if (sum > n) {
                if (k > 0) {
                    int poll = pq.poll();
                    sum -= poll;
                    k--;
                } else {
                    return i;
                }
            }
        }

        return len;
    }
}