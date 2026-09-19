import java.util.stream.*;

class Solution {
    public long solution(int price, int money, int count) {
        long sum = LongStream.rangeClosed(1, count)
                .map(x -> x * price)
                .sum();

        return sum - money >= 0 ? sum - money : 0;
    }
}