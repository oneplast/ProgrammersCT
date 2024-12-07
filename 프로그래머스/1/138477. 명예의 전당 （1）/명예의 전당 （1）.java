import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();

        for (int data : score) {
            if (pq.size() >= k) {
                if (data > pq.peek()) {
                    pq.poll();
                    pq.offer(data);
                }
            } else {
                pq.offer(data);
            }
            answer.add(pq.peek());
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }
}