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

        String u = new String(chars, start, lastIdx - start);

        if (checkValid(u.toCharArray())) {
            return u + solve(chars, lastIdx, end);
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

    private boolean checkValid(char[] chars) {
        int cnt = 0;
        for (char c : chars) {
            if (c == '(') {
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
