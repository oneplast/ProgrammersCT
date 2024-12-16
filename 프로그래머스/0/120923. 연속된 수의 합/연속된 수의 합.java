import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int num, int total) {
        int startNum = 1;
        int lastNum = num;

        while (true) {
            int sum = IntStream.rangeClosed(startNum, lastNum)
                    .sum();

            if (sum == total) {
                return IntStream.rangeClosed(startNum, lastNum)
                        .toArray();
            } else if (sum > total) {
                startNum -= 1;
                lastNum -= 1;
            } else {
                startNum += 1;
                lastNum += 1;
            }
        }
    }
}
