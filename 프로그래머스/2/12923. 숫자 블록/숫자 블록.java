import java.util.*;

class Solution {

    static int LIMIT = 10_000_000;
    int n;

    public int[] solution(long begin, long end) {
        n = (int) (end - begin + 1);
        int[] dp = new int[n];

        for (long i = begin; i <= end; i++) {
            dp[(int) (i - begin)] = calculate(i);
        }

        return dp;
    }

    private int calculate(long num) {
        if (num == 1) {
            return 0;
        }

        int result = 1;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                long gcd = num / i;

                if (gcd <= LIMIT) {
                    return (int) gcd;
                }

                if (i <= LIMIT) {
                    result = (int) i;
                }
            }
        }

        return result;
    }
}
