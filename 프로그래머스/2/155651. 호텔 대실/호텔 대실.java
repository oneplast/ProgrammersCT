import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> tempPq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (String[] book : book_time) {
            pq.offer(new int[]{toMinute(book[0]), toMinute(book[1]) + 10});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int start = cur[0];

            while (!tempPq.isEmpty() && start >= tempPq.peek()[1]) {
                tempPq.poll();
            }

            tempPq.offer(cur);
            answer = Math.max(answer, tempPq.size());
        }

        return answer;
    }

    private int toMinute(String book) {
        return Integer.parseInt(book.substring(0, 2)) * 60 + Integer.parseInt(book.substring(3));
    }
}
