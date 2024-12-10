class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < queries.length; j++) {
                if (i >= queries[j][0] && i <= queries[j][1] && (i % queries[j][2]) == 0) {
                    arr[i] = arr[i] + 1;
                }
            }
        }

        return arr;
    }
}