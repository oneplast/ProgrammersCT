import java.util.*;

class Solution {
    List<int[]> list;

    public int[][] solution(int n) {
        list = new ArrayList<>();

        this.hanoi(n, 1, 2, 3);

        return list.toArray(new int[0][]);
    }

    private void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            list.add(new int[]{start, to});
            return;
        }

        hanoi(n - 1, start, to, mid);

        list.add(new int[]{start, to});

        hanoi(n - 1, mid, start, to);
    }
}
