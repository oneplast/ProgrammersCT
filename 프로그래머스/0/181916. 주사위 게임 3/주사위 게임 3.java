import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        List<Integer> list = Arrays.asList(a, b, c, d)
                .stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x, y) -> Long.compare(y.getValue(), x.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> sortedList = Arrays.asList(a, b, c, d)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        if (list.size() == 4) {
            return sortedList.stream().min(Comparator.naturalOrder()).get();
        } else if (list.size() == 3) {
            return list.get(1) * list.get(2);
        } else if (list.size() == 2) {
            if (!Objects.equals(sortedList.get(1), sortedList.get(2))) {
                int p = list.get(0);
                int q = list.get(1);
                return (p + q) * Math.abs(p - q);
            } else {
                return (int) Math.pow((10 * list.get(0) + list.get(1)), 2);
            }
        } else {
            return 1111 * list.get(0);
        }
    }
}
