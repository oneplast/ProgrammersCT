import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> subQueue = new LinkedList<>();
        Arrays.stream(numbers).forEach(queue::offer);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (subQueue.isEmpty()) {
                subQueue.offer(cur);
                subQueue.offer(-cur);
                continue;
            }

            int idx = 0;
            int len = subQueue.size();
            while (idx < len) {
                int data = subQueue.poll();
                subQueue.offer(data + cur);
                subQueue.offer(data - cur);
                idx++;
            }
        }

        return (int) subQueue.stream().filter(x -> x == target).count();
    }
}