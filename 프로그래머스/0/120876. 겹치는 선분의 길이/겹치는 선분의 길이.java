import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int sum = 0;
        int[] arr = new int[201];

        for (int[] line : lines) {
            for (int i = line[0] + 100; i < line[1] + 100; i++) {
                arr[i]++;
            }
        }

        for (int data : arr) {
            if (data > 1) {
                sum++;
            }
        }

        return sum;
    }
}
