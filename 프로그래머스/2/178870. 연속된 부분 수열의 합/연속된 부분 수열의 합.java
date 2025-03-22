class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] result = new int[2];
        int n = sequence.length;

        int left = 0;
        int right = left;
        int sum = sequence[left];
        int len = Integer.MAX_VALUE;
        int diff;
        while (right < n) {
            if (sum == k) {
                diff = right - left;

                if (diff < len) {
                    result[0] = left;
                    result[1] = right;
                    len = diff;
                }
            }

            if (sum < k) {
                if (++right < n) sum += sequence[right];
            } else {
                sum -= sequence[left++];
            }
        }

        return result;
    }
}