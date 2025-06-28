class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int i = 1; i <= r2; i++) {
            int maxY = (int) getDistance(r2, i);
            int minY = (int) Math.ceil(getDistance(r1, i));

            answer += (maxY - minY + 1);
        }

        return answer * 4;
    }

    private double getDistance(long r, long y) {
        return Math.sqrt(r * r - y * y);
    }
}