import java.util.*;

class Solution {

    int n;
    static final int SCORE_IDX = 4;
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        n = query.length;
        int[] results = new int[n];
        for (String str : info) {
            String[] bits = str.split(" ");
            dfs(bits, "", 0, Integer.parseInt(bits[SCORE_IDX]));
        }

        for (List<Integer> list : map.values()) {
            list.sort(Comparator.reverseOrder());
        }

        int idx = 0;
        for (String queryStr : query) {
            String[] andSplit = queryStr.replaceAll(" and ", " ").split(" ");
            String[] keyQueries = new String[SCORE_IDX];
            System.arraycopy(andSplit, 0, keyQueries, 0, SCORE_IDX);
            String keyQuery = String.join("", keyQueries);
            List<Integer> keyList = map.getOrDefault(keyQuery, new ArrayList<>());
            results[idx++] = binarySearch(keyList, Integer.parseInt(andSplit[SCORE_IDX]));
        }

        return results;
    }

    private void dfs(String[] bits, String key, int depth, int score) {
        if (depth == SCORE_IDX) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }

        dfs(bits, key + bits[depth], depth + 1, score);
        dfs(bits, key + "-", depth + 1, score);
    }

    private int binarySearch(List<Integer> list, int score) {
        int start = 0;
        int end = list.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= score) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}