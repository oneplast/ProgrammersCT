import java.util.*;

class Solution {

    int row = 5;
    int col = 5;

    public int[] solution(String[][] places) {
        int[] answer = new int[row];

        int idx = 0;
        placeLoop:
        for (String[] place : places) {
            List<int[]> people = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                char[] chars = place[i].toCharArray();
                for (int j = 0; j < col; j++) {
                    if (chars[j] == 'P') {
                        people.add(new int[]{i, j});
                    }
                }
            }

            for (int i = 0; i < people.size(); i++) {
                int[] rc1 = people.get(i);
                for (int j = i + 1; j < people.size(); j++) {
                    int[] rc2 = people.get(j);
                    int distance = getManhattan(rc1[0], rc1[1], rc2[0], rc2[1]);
                    if (distance <= 1) {
                        answer[idx++] = 0;
                        continue placeLoop;
                    }

                    if (distance == 2) {
                        if (!isPossible(rc1, rc2, place)) {
                            answer[idx++] = 0;
                            continue placeLoop;
                        }
                    }
                }
            }

            answer[idx++] = 1;
        }

        return answer;
    }

    private int getManhattan(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    private boolean isPossible(int[] rc1, int[] rc2, String[] place) {
        int r1 = rc1[0];
        int c1 = rc1[1];
        int r2 = rc2[0];
        int c2 = rc2[1];

        if (r1 == r2) {
            int mid = (c1 + c2) / 2;
            if (place[r1].charAt(mid) != 'X') {
                return false;
            }
        } else if (c1 == c2) {
            int mid = (r1 + r2) / 2;
            if (place[mid].charAt(c1) != 'X') {
                return false;
            }
        } else {
            if (place[r1].charAt(c2) != 'X' || place[r2].charAt(c1) != 'X') {
                return false;
            }
        }

        return true;
    }
}
