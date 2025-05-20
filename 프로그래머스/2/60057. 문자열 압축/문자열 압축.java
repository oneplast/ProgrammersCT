import java.util.*;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        
        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String beforeStr = s.substring(0, i);
            int repeat = 1;

            for (int j = i; j <= s.length(); j += i) {
                String nextStr;

                if (j + i <= s.length()) {
                    nextStr = s.substring(j, j + i);
                } else {
                    nextStr = s.substring(j);
                }

                if (beforeStr.equals(nextStr)) {
                    repeat++;
                } else {
                    if (repeat > 1) {
                        sb.append(repeat);
                    }

                    sb.append(beforeStr);
                    beforeStr = nextStr;
                    repeat = 1;
                }
            }

            if (repeat > 1) {
                sb.append(repeat);
            }
            sb.append(beforeStr);

            min = Math.min(min, sb.length());
        }

        return min;
    }
}