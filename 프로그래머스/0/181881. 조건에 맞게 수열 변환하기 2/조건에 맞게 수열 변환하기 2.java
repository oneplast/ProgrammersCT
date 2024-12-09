import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] newArr = arr.clone();

        while (true) {
            for (int i = 0; i < arr.length; i++) {
                int x = arr[i];
                if (x >= 50 && (x % 2 == 0)) {
                    arr[i] = x / 2;
                } else if (x < 50 && (x % 2 == 1)) {
                    arr[i] = x * 2 + 1;
                } else {
                    arr[i] = x;
                }
            }

            if (Arrays.equals(newArr, arr)) {
                return answer;
            }

            answer++;
            newArr = arr.clone();
        }
    }
}