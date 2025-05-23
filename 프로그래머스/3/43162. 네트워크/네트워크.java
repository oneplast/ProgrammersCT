import java.util.*;

class Solution {
    int[] parents;

    public int solution(int n, int[][] computers) {
        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(parents[i]));
        }

        return set.size();
    }

    private void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if (aP != bP) {
            parents[aP] = bP;
        }
    }

    private int find(int a) {
        if (a == parents[a]) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}