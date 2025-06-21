import java.util.*;

class Solution {
    int n, m;
    int[][] land;
    int[][] visited;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Map<Integer, Integer> oilSize = new HashMap<>();

    public int solution(int[][] land) {
        this.n = land.length;
        this.m = land[0].length;
        this.land = land;
        this.visited = new int[n][m];

        int id = 1;

        // BFS로 덩어리별 ID 부여 및 크기 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    int size = bfs(i, j, id);
                    oilSize.put(id, size);
                    id++;
                }
            }
        }

        int maxOil = 0;

        // 각 열마다 아래로 훑어서 덩어리 ID 수집
        for (int col = 0; col < m; col++) {
            Set<Integer> touched = new HashSet<>();

            for (int row = 0; row < n; row++) {
                int oilId = visited[row][col];
                if (oilId != 0) {
                    touched.add(oilId);
                }
            }

            int total = 0;
            for (int oilId : touched) {
                total += oilSize.get(oilId);
            }

            maxOil = Math.max(maxOil, total);
        }

        return maxOil;
    }

    private int bfs(int x, int y, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = id;

        int count = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1];

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (land[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = id;
                        queue.offer(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}