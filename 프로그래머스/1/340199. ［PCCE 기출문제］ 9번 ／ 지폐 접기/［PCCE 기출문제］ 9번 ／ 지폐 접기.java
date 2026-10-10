import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);

        while (Math.min(bill[0], bill[1]) > wallet[0]
                || Math.max(bill[0], bill[1]) > wallet[1]
        ) {
            bill[bill[0] > bill[1] ? 0 : 1] /= 2;
            answer++;
        }

        return answer;
    }
}