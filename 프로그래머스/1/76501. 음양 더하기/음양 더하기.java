import java.util.stream.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int size = absolutes.length;
        
        return IntStream.range(0, size)
                .map(i -> signs[i] ? absolutes[i] : -absolutes[i])
                .sum();
    }
}
