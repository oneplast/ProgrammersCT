class Solution {
    public long solution(int w, int h) {
        long total = (long) w * h;

        return total - (w + h - gcd(w, h));
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}