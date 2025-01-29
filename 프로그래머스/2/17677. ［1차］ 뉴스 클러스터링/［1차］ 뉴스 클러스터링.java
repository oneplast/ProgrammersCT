import java.util.*;

class Solution {
    static final int MUL = 65536;

    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);

            if (Character.isLetter(ch1) && Character.isLetter(ch2)) {
                list1.add((String.valueOf(ch1) + String.valueOf(ch2)).toLowerCase());
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);

            if (Character.isLetter(ch1) && Character.isLetter(ch2)) {
                list2.add((String.valueOf(ch1) + String.valueOf(ch2)).toLowerCase());
            }
        }

        int union = list1.size() + list2.size();
        int intersection = 0;

        int idx = 0;
        while (idx < list1.size()) {
            String str = list1.get(idx);

            if (list2.contains(str)) {
                list1.remove(str);
                list2.remove(str);
                intersection++;
            } else {
                idx++;
            }
        }

        union -= intersection;

        return intersection == 0 ?
                union == 0 ? MUL : 0
                : (int) Math.floor(((double) intersection / union) * MUL);
    }
}