class Solution {
    public int solution(int a, int b) {
        b /= gcd(a, b);

        if (b % 2 == 0) {
            while (b % 2 == 0) {
                b /= 2;
            }
        }

        if (b % 5 == 0) {
            while (b % 5 == 0) {
                b /= 5;
            }
        }

        return b == 1 ? b : 2;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
