import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        List<int[]> list = new ArrayList<>(Arrays.asList(data));
        int colIdx = col - 1;

        list.sort((a, b) -> {
            if (a[colIdx] == b[colIdx]) {
                return b[0] - a[0];
            }
            return a[colIdx] - b[colIdx];
        });

        int result = 0;
        List<Integer> beforeXorList = new ArrayList<>();
        for (int i = row_begin; i <= row_end; i++) {
            int s_i = 0;
            int rowIdx = i - 1;
            for (int j = 0; j < list.get(rowIdx).length; j++) {
                s_i += list.get(rowIdx)[j] % i;
            }
            beforeXorList.add(s_i);
        }

        for (int num : beforeXorList) {
            result ^= num;
        }

        return result;
    }
}