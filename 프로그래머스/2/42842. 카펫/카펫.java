import java.util.*;

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[] solution(int brown, int yellow) {
        int nm = brown + yellow;
        List<Integer> list = new ArrayList<>();
        for (int i = 3; i <= nm / 2; i++) {
            if (nm % i == 0 && !list.contains(i) && (nm / i) >= 3) {
                list.add(i);
                list.add(nm / i);
            }
        }

        int idx = 0;
        while (idx < list.size()) {
            int n = list.get(idx);
            int m = idx % 2 == 0 ? list.get(idx + 1) : list.get(idx - 1);
            int[][] board = new int[n][m];
            board[0][0] = 1;
            int dir = 0;

            int x = 0;
            int y = 0;
            while (true) {
                x += dirs[dir][1];
                y += dirs[dir][0];

                if (x >= 0 && x < m && y >= 0 && y < n) {
                    board[y][x] = 1;
                } else {
                    x -= dirs[dir][1];
                    y -= dirs[dir][0];
                    dir = (dir + 1) % dirs.length;
                    if (dir == 0) {
                        break;
                    }
                }
            }

            int cnt = (int) Arrays.stream(board).flatMapToInt(Arrays::stream).filter(a -> a == 1).count();

            if (cnt == brown) {
                return new int[]{m, n};
            } else {
                idx++;
            }
        }

        return new int[]{-1};
    }
}
