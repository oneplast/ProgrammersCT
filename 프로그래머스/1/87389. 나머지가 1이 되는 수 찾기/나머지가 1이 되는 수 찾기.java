class Solution {
    public int solution(int n) {
        int resultN = n - 1;
        for (int i = 2; i * i <= resultN; i++) {
            if (resultN % i == 0) {
                return i;
            }
        }

        return resultN;
    }
}