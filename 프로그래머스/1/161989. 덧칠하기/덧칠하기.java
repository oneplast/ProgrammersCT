class Solution {
    public int solution(int n, int m, int[] section) {
        int result = 0;
        int max = section[section.length - 1];

        int i = 0;
        while (i < section.length) {
            int left = section[i];
            int right = left + m - 1;
            result++;

            while (right <= n) {
                if (right >= section[i]) {
                    i++;
                } else {
                    break;
                }

                if (i >= section.length) {
                    return result;
                }
            }

            if (right >= max) {
                return result;
            }
        }

        return -1;
    }
}