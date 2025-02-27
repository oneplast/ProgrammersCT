import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;

            for (int j = 0; j < targets[i].length(); j++) {
                int min = Integer.MAX_VALUE;

                for (String keyBit : keymap) {
                    String curStr = String.valueOf(targets[i].charAt(j));
                    int curIdx = keyBit.indexOf(curStr) + 1;

                    if (curIdx == 0) {
                        continue;
                    }

                    min = Math.min(min, curIdx);
                }

                if (min == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }
                
                sum += min;
            }

            answer[i] = sum;
        }

        return answer;
    }
}