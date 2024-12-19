import java.util.stream.*;

class Solution {
    public int solution(int n) {
        return (int) IntStream.rangeClosed(2, n)
                .filter(this::isPrime)
                .count();
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
