class Solution {
    public int solution(int n, int[] stations, int w) {
        int result = 0;
        int depth = (2 * w) + 1;
        int startIdx = 1;

        for (int station : stations) {
            int left = station - w;
            int right = station + w;

            if (startIdx < left) {
                int diff = left - startIdx;
                result += (diff + depth - 1) / depth;
            }

            startIdx = right + 1;
        }

        if (startIdx <= n) {
            int diff = n - startIdx + 1;
            result += (diff + depth - 1) / depth;
        }

        return result;
    }
}
