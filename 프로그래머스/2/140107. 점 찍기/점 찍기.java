class Solution {
    public long solution(int k, int d) {
        long result = 0;

        for (long i = 0; i <= d; i += k) {
            long cnt = getDistance(d, i);
            result += (cnt / k) + 1;
        }

        return result;
    }

    private long getDistance(long a, long b) {
        return (long) Math.sqrt(a * a - b * b);
    }
}