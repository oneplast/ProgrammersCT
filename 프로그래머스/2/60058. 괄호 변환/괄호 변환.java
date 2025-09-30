class Solution {
    public String solution(String p) {
        if (p == null || p.isEmpty()) {
            return "";
        }

        return solve(p.toCharArray(), 0, p.length());
    }

    private String solve(char[] chars, int start, int end) {
        if (start >= end) {
            return "";
        }

        int cnt = 0;
        int lastIdx = start;
        for (int i = start; i < end; i++) {
            if (chars[i] == '(') {
                ++cnt;
            } else {
                --cnt;
            }

            if (cnt == 0) {
                lastIdx = i + 1;
                break;
            }
        }

        if (checkValid(chars, start, lastIdx)) {
            StringBuilder sb = new StringBuilder(lastIdx - 1 + (end - lastIdx));
            for (int i = start; i < lastIdx; i++) {
                sb.append(chars[i]);
            }

            sb.append(solve(chars, lastIdx, end));
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solve(chars, lastIdx, end));
            sb.append(")");

            for (int i = start + 1; i < lastIdx - 1; i++) {
                sb.append(chars[i] == '(' ? ')' : '(');
            }

            return sb.toString();
        }
    }

    private boolean checkValid(char[] chars, int start, int end) {
        int cnt = 0;
        for (int i = start; i < end; i++) {
            if (chars[i] == '(') {
                ++cnt;
            } else {
                --cnt;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}
