import java.util.*;

class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, -1}};
    public int[] solution(int n) {
        int size = 0;
        int[][] result = new int[n][];
        boolean[][] visited = new boolean[n][];

        for (int i = 1; i <= n; i++) {
            result[i - 1] = new int[i];
            visited[i - 1] = new boolean[i];
            size += result[i - 1].length;
        }

        result[0][0] = 1;
        visited[0][0] = true;
        int cnt = 2;
        int dIdx = 0;
        int i = 0;
        int j = 0;
        int[] dir;
        while (cnt <= size) {
            dir = dirs[dIdx];
            while (i + dir[0] < result.length && j + dir[1] < result[i].length && !visited[i + dir[0]][j + dir[1]]) {
                i += dir[0];
                j += dir[1];
                result[i][j] = cnt++;
                visited[i][j] = true;
            }
            dIdx = (dIdx + 1) % dirs.length;
        }

        return Arrays.stream(result).flatMapToInt(Arrays::stream).toArray();
    }
}