import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String p) {

        if (p.isEmpty()) {
            return "";
        }

        int lastIdx = -1;
        int sCnt = 0;
        int eCnt = 0;
        char[] chars = p.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                ++sCnt;
            } else {
                ++eCnt;
            }
            if (sCnt == eCnt) {
                lastIdx = i + 1;
                break;
            }
        }

        String u = p.substring(0, lastIdx);
        String v = lastIdx >= chars.length ? "" : p.substring(lastIdx);

        StringBuffer sb = new StringBuffer();
        if (checkValid(u)) {
            sb.append(u);
            return sb.append(solution(v)).toString();
        } else {
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            u = u.substring(1, u.length() - 1);
            return sb.append(reversStr(u)).toString();
        }
    }

    private boolean checkValid(String u) {
        Stack<Character> stack = new Stack<>();
        for (char c : u.toCharArray()) {
            if (stack.isEmpty() || c == '(') {
                stack.add(c);
                continue;
            }

            if (stack.peek() == '(' && c == ')') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private String reversStr(String str) {
        return Arrays.stream(str.split(""))
                .map(s -> {
                    switch (s) {
                        case "(":
                            return ")";
                        case ")":
                            return "(";
                        default:
                            return "";
                    }
                }).collect(Collectors.joining());
    }
}