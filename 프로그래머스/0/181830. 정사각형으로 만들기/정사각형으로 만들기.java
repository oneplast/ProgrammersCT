import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int M = arr.length;
        int N = arr[0].length;
        int max = Math.max(M, N);
        int[][] answer = new int[max][max];

        for (int i = 0; i < M; i++) {
            System.arraycopy(arr[i], 0, answer[i], 0, N);
        }

        return answer;
    }
}
