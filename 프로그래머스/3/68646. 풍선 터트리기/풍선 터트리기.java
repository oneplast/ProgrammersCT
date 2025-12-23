class Solution {
    public int solution(int[] a) {
        int result = 0;
        int len = a.length;
        int[] rightMin = new int[len];
        rightMin[len - 1] = a[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < rightMin.length; i++) {
            if (i == 0 || i == len - 1) {
                ++result;
            } else {
                int right = rightMin[i + 1];

                if (a[i] < leftMin || a[i] < right) {
                    ++result;
                }
            }

            leftMin = Math.min(leftMin, a[i]);
        }

        return result;
    }
}
