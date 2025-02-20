import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("");

        for (int i = 0; i < 26; i++) {
            list.add(Character.toString((char) ('A' + i)));
        }

        int idx = 0;
        while (idx < msg.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(idx));

            while (true) {
                if (list.contains(sb.toString())) {
                    idx++;
                    if (idx < msg.length()) {
                        sb.append(msg.charAt(idx));
                        continue;
                    }
                }
                break;
            }

            if (idx >= msg.length()) {
                answer.add(list.indexOf(sb.toString()));
                break;
            }

            String subStr = sb.substring(0, sb.length() - 1);
            int answerIdx = list.indexOf(subStr);

            answer.add(answerIdx);
            list.add(sb.toString());
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }
}