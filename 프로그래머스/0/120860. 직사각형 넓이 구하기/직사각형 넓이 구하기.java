import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        dots = Arrays.stream(dots).sorted((a, b) -> Integer.compare(a[0], b[0])).toArray(int[][]::new);
        int width = 0;
        int height = 0;

        width = Math.abs(dots[0][1] - dots[1][1]);
        height = Math.abs(dots[1][0] - dots[2][0]);

        return width * height;
    }
}
