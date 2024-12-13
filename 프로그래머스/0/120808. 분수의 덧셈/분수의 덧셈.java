class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] result = new int[2];
        int lcm = lcm(denom1, denom2);
        int temp = (lcm / denom1) * numer1 + (lcm / denom2) * numer2;

        int gcd = gcd(temp, lcm);

        result[0] = temp / gcd;
        result[1] = lcm / gcd;
        return result;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
