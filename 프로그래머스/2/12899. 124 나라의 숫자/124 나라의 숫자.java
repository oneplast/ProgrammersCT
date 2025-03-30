class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] restArr = {4, 1, 2};

        int rest;
        while (n > 0) {
            rest = n % 3;
            sb.insert(0, restArr[rest]);

            if (rest == 0) {
                n = (n / 3) - 1;
            } else {
                n /= 3;
            }
        }

        return sb.toString();
    }
}