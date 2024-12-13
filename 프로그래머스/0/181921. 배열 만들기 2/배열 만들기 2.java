import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(5);

        while (!q.isEmpty()) {
            int data = q.poll();

            if (data < l) {
                q.offer(data * 10);
                q.offer(data * 10 + 5);
                continue;
            }

            if (data > r) {
                continue;
            }

            list.add(data);

            q.offer(data * 10);
            q.offer(data * 10 + 5);
        }

        Collections.sort(list);

        return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(x -> x).toArray();
    }
}
