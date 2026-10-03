class Solution {
    private final int MOD = 7;
    private String[] date = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    private int[] dateDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 30};

    public String solution(int a, int b) {
        int startDateIdx = 4;
        for (int i = 0; i < a - 1; i++) {
            startDateIdx += dateDays[i];
        }
        startDateIdx += b;

        return date[startDateIdx % MOD];
    }
}