class Solution {
    private static final String LATTE = "latte";

    public int solution(String[] order) {
        int result = 0;
        for (String menu : order) {
            if (menu.contains(LATTE)) {
                result += 5000;
            } else {
                result += 4500;
            }
        }

        return result;
    }
}