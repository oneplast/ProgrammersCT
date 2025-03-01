import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (n > s) {
            return new int[]{-1};
        }

        Arrays.fill(answer, s / n);

        int rest = s - ((s / n) * n);

        for (int i = 0; i < rest; i++) {
            answer[i] += 1;
        }

        Arrays.sort(answer);

        return answer;
    }
}