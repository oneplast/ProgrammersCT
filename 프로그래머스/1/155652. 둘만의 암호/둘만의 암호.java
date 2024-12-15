import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();

        for (Character ch : skip.toCharArray()) {
            set.add(ch);
        }

        for (int i = 0; i < s.length(); i++) {
            char newChar = s.charAt(i);
            int idx = 0;

            while (idx < index) {
                newChar++;

                if(newChar > 'z') {
                    newChar -= 26;
                }

                if (!set.contains(newChar)) {
                    idx++;
                }
            }

            sb.append(newChar);
        }

        return sb.toString();
    }
}
