import java.util.*;

class Solution {
    static int[][] arr = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    public int solution(int[] picks, String[] minerals) {
        int result = 0;
        List<int[]> jewels = new ArrayList<>();
        int pickSum = Arrays.stream(picks).sum();

        for (int i = 0; i < minerals.length && jewels.size() < pickSum; i += 5) {
            int[] group = new int[3];
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                switch (minerals[j]) {
                    case "diamond":
                        ++group[0];
                        break;
                    case "iron":
                        ++group[1];
                        break;
                    case "stone":
                        ++group[2];
                        break;
                }
            }
            jewels.add(group);
        }

        jewels.sort((a, b) -> getFatigue(b) - getFatigue(a));

        int groupIdx = 0;
        for (int i = 0; i < 3; i++) {
            while (picks[i]-- > 0 && groupIdx < jewels.size()) {
                int[] group = jewels.get(groupIdx++);
                result += group[0] * arr[i][0] + group[1] * arr[i][1] + group[2] * arr[i][2];
            }
        }

        return result;
    }

    private int getFatigue(int[] group) {
        return group[0] * 25 + group[1] * 5 + group[2];
    }
}