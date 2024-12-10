import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] str_list) {
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                return IntStream.range(0, i)
                        .mapToObj(x -> str_list[x])
                        .toArray(String[]::new);
            }

            if (str_list[i].equals("r")) {
                return IntStream.range(i + 1, str_list.length)
                        .mapToObj(x -> str_list[x])
                        .toArray(String[]::new);
            }
        }

        return new String[]{};
    }
}