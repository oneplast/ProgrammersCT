import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        for (String str : arr) {
            sb.append(str);
        }

        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}