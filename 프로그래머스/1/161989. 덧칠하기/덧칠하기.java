class Solution {
    public int solution(int n, int m, int[] section) {
        int result = 0;
        int filled = 0;

        for (int part : section) {
            if (part > filled) {
                result++;
                filled = part + m - 1;
            }
        }

        return result;
    }
}