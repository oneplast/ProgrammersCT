import java.util.*;

class Solution {
    public int solution(int[] numbers, int k) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(numbers).forEach(x -> queue.offer(x));
        int first = queue.poll();
        queue.offer(first);

        int result = 1;
        int cnt = 1;

        while (cnt != k) {
            int data = queue.poll();
            queue.offer(data);
            result = queue.poll();
            queue.offer(result);
            cnt++;
        }

        return result;
    }
}