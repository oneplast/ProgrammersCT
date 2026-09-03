class Solution {
    public int[] solution(int brown, int yellow) {
        int totalSize = brown + yellow;

        for (int row = 3; row <= Math.sqrt(totalSize); row++) {
            if (totalSize % row != 0) {
                continue;
            }

            int col = totalSize / row;

            if (2 * (row + col) - 4 == brown) {
                return new int[]{col, row};
            }
        }

        return new int[]{-1};
    }
}
