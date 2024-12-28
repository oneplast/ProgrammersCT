import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int[] arr = new int[want.length];

        int idx = 0;
        int result = 0;
        while (idx < discount.length) {
            String str = discount[idx];

            for (int i = 0; i < want.length; i++) {
                if (want[i].equals(str)) {
                    arr[i]++;
                    break;
                }
            }

            idx++;

            if (idx >= 10) {
                if (Arrays.toString(arr).equals(Arrays.toString(number))) {
                    result++;
                }

                if (idx == discount.length) {
                    break;
                }

                for (int i = 0; i < want.length; i++) {
                    if (want[i].equals(discount[idx - 10])) {
                        arr[i]--;
                        break;
                    }
                }
            }
        }

        return result;
    }
}