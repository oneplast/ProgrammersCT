import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int[] sortedCitations = Arrays.stream(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int hIdx;
        int result = 0;
        for (int i = 0; i < sortedCitations.length; i++) {
            hIdx = i + 1;
            if (sortedCitations[i] < hIdx) {
                return result;
            }

            result++;
        }

        return result;
    }
}
