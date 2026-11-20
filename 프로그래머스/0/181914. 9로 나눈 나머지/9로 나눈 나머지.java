import java.util.*;

class Solution {
    static final int MOD = 9;

    public int solution(String number) {
        return Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .sum() % MOD;
    }
}