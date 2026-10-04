import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int result = 0;

        int[] arr = Arrays.stream(score)
                .sorted()
                .skip(score.length % m)
                .toArray();

        for (int i = 0; i < arr.length; i += m) {
            result += arr[i] * m;
        }

        return result;
    }
}