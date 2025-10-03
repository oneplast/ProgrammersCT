import java.util.*;

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    char[][] containers;
    int n;
    int m;
    int answer;

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        answer = n * m;

        containers = new char[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(storage[i].toCharArray(), 0, containers[i], 0, m);
        }

        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() == 2) {
                removeByCrane(target);
            } else {
                removeByCar(target);
            }
        }

        return answer;
    }

    private void removeByCrane(char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (containers[i][j] == target) {
                    containers[i][j] = '0';
                    --answer;
                }
            }
        }
    }

    private void removeByCar(char target) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (containers[i][0] == '0') {
                queue.offer(new int[]{i, 0});
                visited[i][0] = true;
            }

            if (containers[i][m - 1] == '0') {
                queue.offer(new int[]{i, m - 1});
                visited[i][m - 1] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            if (containers[0][i] == '0') {
                queue.offer(new int[]{0, i});
                visited[0][i] = true;
            }

            if (containers[n - 1][i] == '0') {
                queue.offer(new int[]{n - 1, i});
                visited[n - 1][i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m
                        && !visited[nextRow][nextCol] && containers[nextRow][nextCol] == '0') {
                    queue.offer(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (containers[i][j] == target) {
                    for (int[] dir : dirs) {
                        int nextRow = i + dir[0];
                        int nextCol = j + dir[1];

                        if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m ||
                                (containers[nextRow][nextCol] == '0' && visited[nextRow][nextCol])) {
                            containers[i][j] = '0';
                            --answer;
                            break;
                        }
                    }
                }
            }
        }
    }
}
