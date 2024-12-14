class Solution {
    public int solution(int[] common) {
        boolean flag = true;
        if ((common[1] - common[0]) == (common[2] - common[1])) {
        } else if ((common[1] / common[0]) == (common[2] / common[1])) {
            flag = false;
        }

        int n = common.length - 1;
        int diff = 0;
        if (flag) {
            diff = common[n] -common[n - 1];
            return common[n] + diff;
        } else {
            diff = common[n] / common[n - 1];
            return common[n] * diff;
        }
    }
}
