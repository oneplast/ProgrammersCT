import java.util.*;

class Solution {

    Map<String, Integer> empMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int size = enroll.length;
        int[] parent = new int[size];
        int[] benefits = new int[size];

        for (int i = 0; i < size; i++) {
            empMap.put(enroll[i], i);
        }

        for (int i = 0; i < size; i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else {
                parent[i] = empMap.get(referral[i]);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            int curIdx = empMap.get(seller[i]);
            int earning = amount[i] * 100;

            while (curIdx != -1) {
                int benefit = earning / 10;
                benefits[curIdx] += earning - benefit;
                earning = benefit;
                curIdx = parent[curIdx];
            }
        }

        return benefits;
    }
}