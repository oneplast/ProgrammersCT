import java.util.*;

class Solution {
    static List<Integer> list = new ArrayList<>(Arrays.asList(1, -1));

    public long solution(int[] sequence) {
        if (sequence.length == 1) {
            return Math.max(sequence[0], -sequence[0]);
        }

        return divide(sequence, 0, sequence.length - 1);
    }

    private long divide(int[] sequence, int left, int right) {
        if (left == right) {
            return sequence[left];
        }

        int mid = left + (right - left) / 2;
        long maxLeft = divide(sequence, left, mid);
        long maxRight = divide(sequence, mid + 1, right);
        long maxSequence = conquer(sequence, left, mid, right);

        return Math.max(maxLeft, Math.max(maxRight, maxSequence));
    }

    private long conquer(int[] sequence, int left, int mid, int right) {
        long sumFirst = calculateMaxSum(sequence, 0, left, mid, right);
        long sumSecond = calculateMaxSum(sequence, 1, left, mid, right);

        return Math.max(sumFirst, sumSecond);
    }

    private long calculateMaxSum(int[] sequence, int idx, int left, int mid, int right) {
        long sumLeft = 0;
        int listIdx = idx;
        long maxLeft = Long.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sumLeft += ((long) sequence[i] * list.get(listIdx % 2));
            listIdx++;
            maxLeft = Math.max(maxLeft, sumLeft);
        }

        long sumRight = 0;
        listIdx = idx + 1;
        long maxRight = Long.MIN_VALUE;

        for (int i = mid + 1; i <= right; i++) {
            sumRight += ((long) sequence[i] * list.get(listIdx % 2));
            listIdx++;
            maxRight = Math.max(maxRight, sumRight);
        }

        return maxLeft + maxRight;
    }
}