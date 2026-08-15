class Solution {
    public int solution(int n) {
        int result = 1;

        int start = 1;
        int next;
        while (start < n) {
            boolean isPossible = false;
            int sum = start;
            next = start + 1;
            
            while (sum < n) {
                sum += next;
                next++;
            }

            if (sum == n) {
                isPossible = true;
            }

            if (isPossible) {
                result++;
            }

            start++;
        }

        return result;
    }
}