import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        List<String> list = new ArrayList<>();
        char[] chars = myStr.toCharArray();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            char c = chars[i];

            if (c != 'a' && c != 'b' && c != 'c') {
                sb.append(c);
            } else {
                if (sb.length() != 0) {
                    list.add(sb.toString());
                }
                sb = new StringBuilder();
            }

            i++;
            if (i == chars.length) {
                if (sb.length() != 0) {
                    list.add(sb.toString());
                }

                break;
            }
        }

        return list.isEmpty() ? new String[]{"EMPTY"} : list.stream().toArray(String[]::new);
    }
}