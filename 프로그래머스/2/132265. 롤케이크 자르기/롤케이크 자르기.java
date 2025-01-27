import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> first = new HashSet<>();
        Map<Integer, Integer> second = new HashMap<>();
        first.add(topping[0]);
        Arrays.stream(topping, 1, topping.length).forEach(x -> second.put(x, second.getOrDefault(x, 0) + 1));

        if (first.size() == second.size()) {
            answer++;
        }

        int idx = 1;
        while (idx < topping.length) {
            int data = topping[idx];

            first.add(data);
            second.put(data, second.get(data) - 1);

            if (second.get(data) == 0) {
                second.remove(data);
            }

            if (first.size() == second.size()) {
                answer++;
            }

            idx++;
        }

        return answer;
    }
}