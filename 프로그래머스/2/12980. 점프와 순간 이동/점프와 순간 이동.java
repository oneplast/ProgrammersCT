class Solution {
    public int solution(int n) {
        if (n == 1) {
            return 1;
        }

        int result;
        if (n % 2 == 0) {
            result = solution(n / 2);
        } else {
            result = solution((n - 1) / 2) + 1;
        }

        return result;
    }
}