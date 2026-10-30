import java.util.*;

class Solution {
    static final int LOSER = 6;

    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();
        Arrays.stream(win_nums).forEach(winSet::add);

        Map<Integer, Integer> rankMap = new HashMap<>();
        rankMap.put(6, 1);
        rankMap.put(5, 2);
        rankMap.put(4, 3);
        rankMap.put(3, 4);
        rankMap.put(2, 5);

        int zeroCnt = (int) Arrays.stream(lottos)
                .filter(i -> i == 0)
                .count();

        int collectCnt = (int) Arrays.stream(lottos)
                .filter(winSet::contains)
                .count();

        int min = collectCnt;
        int max = collectCnt + zeroCnt;

        return new int[]{rankMap.getOrDefault(max, LOSER), rankMap.getOrDefault(min, LOSER)};
    }
}