import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int result = 0;
        Set<String> set = new HashSet<>(Arrays.asList("aya", "ye", "woo", "ma"));

        int idx = 0;
        while (idx < babbling.length) {
            String curStr = babbling[idx];

            String prevStr = "";
            loop:
            while (true) {
                for (String setStr : set) {
                    if (curStr.startsWith(setStr)) {
                        if (setStr.equals(prevStr)) {
                            break loop;
                        }

                        curStr = curStr.substring(setStr.length());
                        prevStr = setStr;
                        continue loop;
                    }
                }

                break;
            }

            if (curStr.isEmpty()) {
                result++;
            }

            idx++;
        }

        return result;
    }
}
