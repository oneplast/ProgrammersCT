class Solution {
    public int solution(int[][] sizes) {
        int maxWeight = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            maxWeight = Math.max(maxWeight, Math.max(size[0], size[1]));
            maxHeight = Math.max(maxHeight, Math.min(size[0], size[1]));
        }

        return maxWeight * maxHeight;
    }
}