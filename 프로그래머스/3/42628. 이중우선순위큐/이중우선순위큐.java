import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        String[] bits;
        String op;
        int num, max;
        for (String operation : operations) {
            bits = operation.split(" ");
            op = bits[0];
            num = Integer.parseInt(bits[1]);

            if (op.equals("I")) {
                pq.offer(num);
            } else if (!pq.isEmpty()) {
                if (num == -1) {
                    pq.poll();
                } else {
                    max = Collections.max(pq);
                    pq.remove(max);
                }
            }
        }

        return pq.isEmpty()
                ? new int[]{0, 0}
                : new int[]{Collections.max(pq), pq.peek()};
    }
}