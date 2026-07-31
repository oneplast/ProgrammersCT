import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        int[] counts = new int[10];
        for (int number : numbers) {
            counts[number]++;
        }

        return IntStream.range(0, counts.length)
                .filter(i -> counts[i] == 0)
                .sum();
    }
}
