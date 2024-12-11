class Solution {
    public int solution(int chicken) {
        int result = 0;

        while (chicken >= 10) {
            int divide = chicken / 10;
            int rest = chicken % 10;

            chicken = divide + rest;
            result += divide;
        }

        return result;
    }
}
