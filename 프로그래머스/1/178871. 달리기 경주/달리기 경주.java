import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int idx = map.get(calling);

            if (idx > 0) {
                map.put(players[idx - 1], idx);
                map.put(calling, idx - 1);
                this.swap(players, idx, idx - 1);
            }
        }

        return players;
    }

    private void swap(String[] players, int idx1, int idx2) {
        String temp = players[idx1];
        players[idx1] = players[idx2];
        players[idx2] = temp;
    }
}
