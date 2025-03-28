import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            map.put(i, new int[]{(i - 1) / 3, (i - 1) % 3});
        }
        map.put(0, new int[]{3, 1});

        int[] left = {3, 0};
        int[] right = {3, 2};
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            int[] cur = map.get(number);
            if (number % 3 == 2 || number == 0) {
                if (getDiff(left, cur) < getDiff(right, cur)) {
                    left = cur;
                    sb.append("L");
                } else if (getDiff(left, cur) == getDiff(right, cur)) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = cur;
                    } else {
                        sb.append("R");
                        right = cur;
                    }
                } else {
                    right = cur;
                    sb.append("R");
                }
            } else if (number % 3 == 1) {
                left = cur;
                sb.append("L");
            } else {
                right = cur;
                sb.append("R");
            }
        }

        return sb.toString();
    }

    private int getDiff(int[] left, int[] right) {
        return Math.abs(right[0] - left[0]) + Math.abs(right[1] - left[1]);
    }
}