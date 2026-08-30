class Solution {
    public int solution(int num) {
        int calculatedNum = num;
        int result = 0;
        while (calculatedNum > 1) {
            calculatedNum = isEven(calculatedNum) ? calculatedNum / 2 : calculatedNum * 3 + 1;
            result++;
        }

        return calculatedNum == 1 ? result : -1;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}