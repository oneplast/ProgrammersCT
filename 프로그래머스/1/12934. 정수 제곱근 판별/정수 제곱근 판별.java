class Solution {
    public long solution(long n) {
        double sqrtN = Math.sqrt(n);

        return sqrtN == (long) sqrtN
                ? (long) (sqrtN + 1) * (long) (sqrtN + 1)
                : -1;
    }
}