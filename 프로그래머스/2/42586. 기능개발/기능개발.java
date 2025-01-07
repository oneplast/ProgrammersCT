import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int idx = 0;
        int cnt = 0;
        while (idx < progresses.length) {
            for (int i = idx; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            if (progresses[idx] >= 100) {
                while (idx < progresses.length && progresses[idx] >= 100) {
                    cnt++;
                    idx++;
                }

                list.add(cnt);
                cnt = 0;
            }
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}