import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<Node> queue = new LinkedList<>();

        int result = 0;

        for (int i = 0; i < players.length; i++) {
            while (!queue.isEmpty() && queue.peek().start + k <= i) {
                queue.poll();
            }

            int n = 1;
            while (n * m <= players[i] && (n + 1) * m > players[i] && queue.size() < n) {
                ++n;
                queue.offer(new Node(i));
                ++result;
            }

            while (queue.size() < players[i] / m) {
                queue.offer(new Node(i));
                ++result;
            }
        }

        return result;
    }

    static class Node {
        int start;

        public Node(int start) {
            this.start = start;
        }
    }
}