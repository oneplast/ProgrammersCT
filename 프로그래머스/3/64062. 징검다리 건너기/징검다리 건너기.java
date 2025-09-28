class Solution {

    public int solution(int[] stones, int k) {
        int left = 0;
        int right = 200000000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(stones, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean isPossible(int[] stones, int k, int mid) {
        int cnt = 0;

        for (int stone : stones) {
            if (stone < mid) {
                ++cnt;
                if (cnt >= k) {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }

        return true;
    }
}
