import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] splitBits = operation.split(" ");
            String oper = splitBits[0];
            int value = Integer.parseInt(splitBits[1]);

            if (oper.equals("I")) {
                set.add(value);
            } else {
                if (value == 1) {
                    if (!set.isEmpty()) {
                        set.pollFirst();
                    }
                } else {
                    if (!set.isEmpty()) {
                        set.pollLast();
                    }
                }
            }
        }

        if (set.isEmpty()) {
            return new int[]{0, 0};
        } else if (set.size() < 2) {
            int data = set.pollFirst();
            return new int[]{data, data};
        }

        return new int[]{set.pollFirst(), set.pollLast()};
    }
}
