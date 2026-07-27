import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> map = new HashMap<>();
		map.merge(a, 1, Integer::sum);
		map.merge(b, 1, Integer::sum);
		map.merge(c, 1, Integer::sum);
		map.merge(d, 1, Integer::sum);
		List<int[]> list = new ArrayList<>();
		map.forEach((key, value) -> list.add(new int[] {key, value}));

		list.sort((f, s) -> s[1] - f[1]);

		int size = list.size();

		switch (size) {
			case 1:
				return 1111 * list.get(0)[0];
			case 2:
				int first = list.get(0)[0];
				int second = list.get(1)[0];
				if (list.get(1)[1] == 2) {
					return (first + second) * Math.abs(first - second);
				} else {
					return (int) Math.pow(10 * list.get(0)[0] + list.get(1)[0], 2);
				}
			case 3:
				return list.get(1)[0] * list.get(2)[0];
			default:
				return list.stream().mapToInt(n -> n[0]).min().getAsInt();
		}
    }
}