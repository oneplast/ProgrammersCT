import java.util.*;
import java.util.stream.*;

class Solution {
    Map<Integer, Map<String, Integer>> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    public String[] solution(String[] orders, int[] course) {
        orders = Arrays.stream(orders)
                .map(x -> {
                    char[] chars = x.toCharArray();
                    Arrays.sort(chars);
                    return String.valueOf(chars);
                })
                .toArray(String[]::new);

        for (int wanna : course) {
            for (String order : orders) {
                if (order.length() < wanna) {
                    continue;
                }
                dfs(order, order.length(), wanna, 0);
            }
        }

        map = map.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        x -> x.getValue().entrySet().stream()
                                .sorted((a, b) -> b.getValue() - a.getValue())
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (a, b) -> a,
                                        LinkedHashMap::new
                                )),
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        List<String> result = new ArrayList<>();
        for (int wanna : course) {
            if (map.containsKey(wanna)) {
                int max = 2;
                for (Map.Entry<String, Integer> entry : map.get(wanna).entrySet()) {
                    if (max > entry.getValue()) {
                        break;
                    }
                    result.add(entry.getKey());
                    max = entry.getValue();
                }
            }
        }

        result.sort(Comparator.naturalOrder());

        return result.toArray(new String[0]);
    }

    private void dfs(String order, int n, int r, int start) {
        if (sb.length() == r) {
            map.computeIfAbsent(r, x -> new HashMap<>())
                    .put(sb.toString(), map.get(r).getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = start; i < n; i++) {
            sb.append(order.charAt(i));
            dfs(order, n, r, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
