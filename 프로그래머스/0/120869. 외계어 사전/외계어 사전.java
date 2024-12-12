import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        for (int i = 0; i < dic.length; i++) {
            Set<String> set = new HashSet<>(Arrays.asList(spell));
            for (int j = 0; j < dic[i].length(); j++) {
                String temp = String.valueOf(dic[i].charAt(j));
                if (set.contains(temp)) {
                    set.remove(temp);
                }
            }

            if (set.isEmpty()) return 1;
        }

        return 2;
    }
}

