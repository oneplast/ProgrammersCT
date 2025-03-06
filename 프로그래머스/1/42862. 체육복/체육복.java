import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int result = n - lost.length;
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reverseSet = new HashSet<>();

        for (int key : lost) {
            lostSet.add(key);
        }

        for (int key : reserve) {
            if (lostSet.contains(key)) {
                lostSet.remove(key);
                result++;
            } else {
                reverseSet.add(key);
            }
        }

        for (int data : lostSet) {
            if (reverseSet.contains(data - 1)) {
                reverseSet.remove(data - 1);
                result++;
            } else if (reverseSet.contains(data + 1)) {
                reverseSet.remove(data + 1);
                result++;
            }
        }

        return result;
    }
}