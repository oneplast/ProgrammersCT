import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, (a, b) -> Integer.compare(a[0], b[0]));

        double case1 = cal(dots[0], dots[1]);
        double case2 = cal(dots[2], dots[3]);
        if (case1 == case2) {
            return 1;
        }

        case1 = cal(dots[0], dots[2]);
        case2 = cal(dots[1], dots[3]);
        if (case1 == case2) {
            return 1;
        }

        case1 = cal(dots[1], dots[2]);
        case2 = cal(dots[0], dots[3]);
        if (case1 == case2) {
            return 1;
        }

        return 0;
    }

    public double cal(int[] arr1, int[] arr2) {
        return Math.abs((double) (arr2[1] - arr1[1]) / (arr2[0] - arr1[0]));
    }
}