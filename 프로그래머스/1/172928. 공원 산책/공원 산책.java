import java.util.*;

class Solution {

    public int[] solution(String[] park, String[] routes) {
        int[] cur = new int[2];
        int n = park.length;
        int m = park[0].length();
        for (int i = 0; i < n; i++) {
            char[] chars = park[i].toCharArray();
            boolean exitFlag = false;
            for (int j = 0; j < m; j++) {
                if (chars[j] == 'S') {
                    cur[0] = i;
                    cur[1] = j;
                    exitFlag = true;
                }
            }

            if (exitFlag) {
                break;
            }
        }

        Map<Character, int[]> routeMap = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            fillMap(routeMap, routes[i]);
            char[] chars = routes[i].toCharArray();
            int[] newInts = routeMap.get(chars[0]);
            int curX = cur[1];
            int curY = cur[0];
            int nextX = curX + newInts[1];
            int nextY = curY + newInts[0];
            int signX = Integer.signum(newInts[1]);
            int signY = Integer.signum(newInts[0]);

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                boolean continueFlag = true;
                while (curX != nextX || curY != nextY) {
                    curX += signX;
                    curY += signY;

                    if (park[curY].charAt(curX) == 'X') {
                        continueFlag = false;
                        break;
                    }
                }

                if (continueFlag) {
                    cur = new int[]{curY, curX};
                }
            }
        }

        return cur;
    }

    private void fillMap(Map<Character, int[]> routeMap, String routes) {
            char[] chars = routes.toCharArray();
            switch (chars[0]) {
                case 'E':
                    routeMap.put(chars[0], new int[]{0, chars[2] - '0'});
                    break;
                case 'W':
                    routeMap.put(chars[0], new int[]{0, -(chars[2] - '0')});
                    break;
                case 'S':
                    routeMap.put(chars[0], new int[]{chars[2] - '0', 0});
                    break;
                default:
                    routeMap.put(chars[0], new int[]{-(chars[2] - '0'), 0});
                    break;
            }
    }
}
