import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] result = new int[2];
        int start = 0;
        int min = Integer.MAX_VALUE;

        Set<String> originGems = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> jewelCnt = new HashMap<>();
        int maxGemSize = originGems.size();
        int curGemSize = 0;

        for (int end = 0; end < gems.length; end++) {
            String gem = gems[end];
            jewelCnt.put(gem, jewelCnt.getOrDefault(gem, 0) + 1);

            if (jewelCnt.get(gem) == 1) {
                ++curGemSize;
            }

            while (curGemSize == maxGemSize) {
                if (min > end - start) {
                    result[0] = start + 1;
                    result[1] = end + 1;
                    min = end - start;
                }

                String beforeGem = gems[start++];
                jewelCnt.put(beforeGem, jewelCnt.get(beforeGem) - 1);

                if (jewelCnt.get(beforeGem) == 0) {
                    --curGemSize;
                }
            }
        }

        return result;
    }
}
