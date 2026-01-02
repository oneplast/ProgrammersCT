class Solution {

    char[] dir = {'d', 'l', 'r', 'u'};
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};

    static final String IMP = "impossible";

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || (k - dist) % 2 == 1) {
            return IMP;
        }

        int curX = x;
        int curY = y;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < dir.length; j++) {
                int nextX = curX + dx[j];
                int nextY = curY + dy[j];

                if (nextX < 1 || nextX > n || nextY < 1 || nextY > m) {
                    continue;
                }

                int newK = k - (i + 1);
                int newDist = Math.abs(nextX - r) + Math.abs(nextY - c);

                if (newDist <= newK && (newK - newDist) % 2 == 0) {
                    sb.append(dir[j]);
                    curX = nextX;
                    curY = nextY;
                    break;
                }
            }
        }

        return sb.toString();
    }
}