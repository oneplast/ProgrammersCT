import java.util.*;
import java.util.stream.*;

class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int max = Integer.MIN_VALUE;

                for (int k = 0; k < land[i].length; k++) {
                    if (k == j) {
                        continue;
                    }

                    max = Math.max(max, land[i - 1][k]);
                }

                land[i][j] += max;
            }
        }

        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }
}
