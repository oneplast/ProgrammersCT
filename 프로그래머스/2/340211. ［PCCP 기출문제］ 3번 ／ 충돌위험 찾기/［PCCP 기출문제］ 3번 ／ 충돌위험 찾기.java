import java.util.*;

class Solution {
    static final int MAX_R = 100;

    public int solution(int[][] points, int[][] routes) {
        List<List<int[]>> paths = new ArrayList<>();

        for (int[] route : routes) {
            paths.add(calPaths(points, route));
        }

        int moveTime = getMoveTime(paths);

        return calculateCollisions(paths, moveTime);
    }

    private List<int[]> calPaths(int[][] points, int[] route) {
        List<int[]> path = new ArrayList<>();

        int[] start = points[route[0] - 1];
        int r = start[0];
        int c = start[1];

        path.add(new int[]{r, c});

        for (int i = 1; i < route.length; i++) {
            int[] dest = points[route[i] - 1];
            move(path, dest, r, c);

            int[] latestPaths = path.get(path.size() - 1);
            r = latestPaths[0];
            c = latestPaths[1];
        }

        return path;
    }

    private void move(List<int[]> path, int[] dest, int r, int c) {
        int destR = dest[0];
        int destC = dest[1];

        while (r != destR) {
            r += (r < destR ? 1 : -1);
            path.add(new int[]{r, c});
        }

        while (c != destC) {
            c += (c < destC ? 1 : -1);
            path.add(new int[]{r, c});
        }
    }

    private int getMoveTime(List<List<int[]>> paths) {
        int max = 0;
        for (List<int[]> path : paths) {
            max = Math.max(max, path.size());
        }

        return max;
    }

    private int calculateCollisions(List<List<int[]>> paths, int moveTime) {
        int result = 0;

        for (int i = 0; i < moveTime; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (List<int[]> path : paths) {
                if (i >= path.size()) {
                    continue;
                }

                int[] cur = path.get(i);
                int key = encode(cur[0], cur[1]);

                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (int cnt : map.values()) {
                if (cnt >= 2) {
                    result++;
                }
            }
        }

        return result;
    }

    private int encode(int r, int c) {
        return r * MAX_R + c;
    }
}