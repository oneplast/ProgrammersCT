import java.util.stream.*;

class Solution {
    public int solution(int[] sides) {
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);

        int case1 = (int) IntStream.rangeClosed(1, max)
                .filter(x -> {
                    if (min + x > max) return true;
                    return false;
                }).count();

        int case2 = (int) IntStream.range(max + 1, max + min).count();

        return case1 + case2;
    }
}
