class Solution {
    public int solution(int n) {
        int incCnt = 0;
        int num = 0;

        while (incCnt < n) {
            num++;

            if (num % 3 == 0 || String.valueOf(num).contains("3")) {
                continue;
            }

            incCnt++;
        }

        return num;
    }
}
