import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 0, y = 0;
        Map<Character, int[]> map = new HashMap<>();
        map.put('L', new int[]{0, -1});
        map.put('R', new int[]{0, 1});
        map.put('U', new int[]{1, 0});
        map.put('D', new int[]{-1, 0});

        Set<String> set = new HashSet<>();

        for (Character dir : dirs.toCharArray()) {
            int[] newDirs = map.get(dir);
            int nextX = x + newDirs[1];
            int nextY = y + newDirs[0];

            if (nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) {
                continue;
            }

            String path1 = "" + y + x + nextY + nextX;
            String path2 = "" + nextY + nextX + y + x;
            if (!set.contains(path1)) {
                set.add(path1);
                set.add(path2);
                answer++;
            }

            x = nextX;
            y = nextY;
        }

        return answer;
    }
}

