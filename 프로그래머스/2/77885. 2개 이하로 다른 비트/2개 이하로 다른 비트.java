import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        int idx = 0;

        int idx01;
        int idx10;
        int idx00;
        int maxIdx;
        String resultBit;
        for (long number : numbers) {
            String baseStr = "0" + Long.toBinaryString(number);

            idx01 = baseStr.lastIndexOf("01");
            idx10 = baseStr.lastIndexOf("10");
            idx00 = baseStr.lastIndexOf("00");
            maxIdx = Math.max(idx01, Math.max(idx10, idx00));

            if (maxIdx == idx01) {
                resultBit = baseStr.substring(0, maxIdx) + "10" + baseStr.substring(maxIdx + 2);
            } else if (maxIdx == idx10) {
                resultBit = baseStr.substring(0, maxIdx) + "11" + baseStr.substring(maxIdx + 2);
            } else {
                resultBit = baseStr.substring(0, maxIdx) + "01" + baseStr.substring(maxIdx + 2);
            }

            result[idx++] = Long.parseLong(resultBit, 2);
        }

        return result;
    }
}