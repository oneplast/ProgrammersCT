import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int rank = 1;
        int[] mine = scores[0];
        int mySum = scores[0][0] + scores[0][1];

        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        int max = Integer.MIN_VALUE;
        List<Integer> sums = new ArrayList<>();

        for (int[] score : scores) {
            if (score[0] > mine[0] && score[1] > mine[1]) {
                return -1;
            }

            if (score[1] >= max) {
                max = score[1];
                sums.add(score[0] + score[1]);
            }
        }

        for (int sum : sums) {
            if (sum > mySum) {
                ++rank;
            }
        }

        return rank;
    }
}