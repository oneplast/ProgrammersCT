import java.util.*;

class Solution {

    List<Set<Integer>> keyList = new ArrayList<>();
    boolean[] isSingleKey;
    int row;
    int col;

    public int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        isSingleKey = new boolean[col];

        for (int i = 0; i < col; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < row; j++) {
                set.add(relation[j][i]);
            }

            if (set.size() == row) {
                keyList.add(new HashSet<>(Arrays.asList(i)));
                isSingleKey[i] = true;
            }
        }

        for (int i = 2; i <= col; i++) {
            combination(relation, new ArrayList<>(), 0, i);
        }

        return keyList.size();
    }

    private void combination(String[][] relation, List<Integer> cols, int start, int size) {
        if (cols.size() == size) {
            checkValid(relation, cols);
            return;
        }

        for (int i = start; i < col; i++) {
            if (isSingleKey[i]) {
                continue;
            }

            cols.add(i);
            combination(relation, cols, i + 1, size);
            cols.remove(cols.size() - 1);
        }
    }

    private void checkValid(String[][] relation, List<Integer> cols) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int num : cols) {
                sb.append(relation[i][num]).append("|");
            }
            set.add(sb.toString());
        }

        if (set.size() != row) {
            return;
        }

         Set<Integer> lineSet = new HashSet<>(cols);
        for (Set<Integer> key : keyList) {
            if (lineSet.containsAll(key)) {
                return;
            }
        }

        keyList.add(lineSet);
    }
}
