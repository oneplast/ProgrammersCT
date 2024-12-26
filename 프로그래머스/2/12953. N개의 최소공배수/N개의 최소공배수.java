import java.util.*;

class Solution {
    public int solution(int[] arr) {
        return Arrays.stream(arr).reduce(this::lcm).getAsInt();
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
