class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int turn = 0;
        int idx = 0;
        while (true) {
            String curStr = Integer.toString(idx, n);

            int splitIdx = 0;
            while (splitIdx < curStr.length()) {
                if (sb.length() == t) {
                    return sb.toString();
                }

                turn++;
                if (turn == p) {
                    String upperString = String.valueOf(curStr.charAt(splitIdx)).toUpperCase();
                    sb.append(upperString);
                }

                turn %= m;
                splitIdx++;
            }

            idx++;
        }
    }
}