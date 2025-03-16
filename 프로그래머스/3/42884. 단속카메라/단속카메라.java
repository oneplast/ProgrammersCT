import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        int result = 1;
        int out = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (out > routes[i][1]) {
                out = routes[i][1];
            } else if (out < routes[i][0]) {
                out = routes[i][1];
                result++;
            }
        }

        return result;
    }
}
