class Solution {
    public int solution(int a, int b, int n) {
        int bottle = n;
        int result = 0;

        while (bottle >= a) {
            int newBottle;
            if (bottle / a > 0) {
                newBottle = (bottle / a) * b;
                result += newBottle;
                bottle = bottle - (bottle / a * a) + newBottle;
            }
        }

        return result;
    }
}