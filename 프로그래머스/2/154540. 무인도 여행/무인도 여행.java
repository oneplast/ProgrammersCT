import java.util.*;

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int n;
    int m;
    boolean[][] visited;

    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String map = maps[i];
            for (int j = 0; j < m; j++) {
                char[] chars = map.toCharArray();
                if (!visited[i][j] && chars[j] != 'X') {
                    int sum = bfs(j, i, maps);
                    results.add(sum);
                }
            }
        }

        return results.isEmpty() ? new int[]{-1} : results.stream().mapToInt(x -> x).sorted().toArray();
    }

    private int bfs(int x, int y, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        int sum = maps[y].charAt(x) - '0';

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[1];
            int curY = cur[0];

            for (int[] dir : dirs) {
                int nextX = curX + dir[1];
                int nextY = curY + dir[0];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && maps[nextY].charAt(nextX) != 'X'
                        && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX});
                    sum += maps[nextY].charAt(nextX) - '0';
                }
            }
        }

        return sum;
    }
}