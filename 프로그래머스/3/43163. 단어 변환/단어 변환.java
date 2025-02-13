class Solution {
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        boolean flag = false;
        for (String word : words) {
            if (word.equals(target)) {
                flag = true;
                break;
            }
        }

        if (!flag) return 0;

        return dfs(begin, target, words, 0);
    }

    public int dfs(String cur, String target, String[] words, int idx) {
        if (cur.equals(target)) {
            return idx;
        }

        int min = Integer.MAX_VALUE;

        int cur_target_diff = 0;
        for (int i = 0; i < target.length(); i++) {
            if (cur.charAt(i) != target.charAt(i)) {
                cur_target_diff++;
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int new_cur_diff = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (cur.charAt(j) != words[i].charAt(j)) {
                    new_cur_diff++;
                }
            }

            if (new_cur_diff == 1 && !visited[i]) {
                int new_target_diff = 0;
                for (int j = 0; j < target.length(); j++) {
                    if (target.charAt(j) != words[i].charAt(j)) {
                        new_target_diff++;
                    }
                }

                if (cur_target_diff >= new_target_diff) {
                    visited[i] = true;
                    int newIdx = dfs(words[i], target, words, idx + 1);
                    if (newIdx != Integer.MAX_VALUE) {
                        min = Math.min(min, newIdx);
                    }
                    visited[i] = false;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}