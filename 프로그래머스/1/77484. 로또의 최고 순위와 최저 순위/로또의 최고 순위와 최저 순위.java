import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> rank = new HashMap<>();
        Map<Integer, Integer> myLotto = new HashMap<>();
        rank.put(6, 1);
        rank.put(5, 2);
        rank.put(4, 3);
        rank.put(3, 4);
        rank.put(2, 5);
        rank.put(1, 6);
        rank.put(0, 6);

        int zeroCnt = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCnt++;
                continue;
            }

            myLotto.put(lottos[i], lottos[i]);
        }

        int correct = 0;
        for (int i = 0; i < win_nums.length; i++) {
            if (myLotto.containsKey(win_nums[i])) {
                correct++;
            }
        }

        return new int[]{rank.get(correct + zeroCnt), rank.get(correct)};
    }
}