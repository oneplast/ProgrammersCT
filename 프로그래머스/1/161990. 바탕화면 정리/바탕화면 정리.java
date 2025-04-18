import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = wallpaper.length, luy = wallpaper[0].length(), rdx = 0, rdy = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            char[] chars = wallpaper[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }
}