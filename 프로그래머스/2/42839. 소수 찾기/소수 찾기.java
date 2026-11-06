import java.util.*;

class Solution {
    static final int LIMIT = 10_000_000;

    private Set<Integer> candidateSet;
    private boolean[] isComposite;
    private boolean[] visited;

    private final StringBuilder sb = new StringBuilder();

    public int solution(String numbers) {
        candidateSet = new HashSet<>();
        isComposite = new boolean[LIMIT];
        visited = new boolean[numbers.length()];

        fillPrime();

        dfs(numbers, 0);

        return (int) candidateSet.stream()
                .filter(i -> i >= 2 && !isComposite[i])
                .count();
    }

    private void fillPrime() {
        for (int i = 2; i * i < LIMIT; i++) {
            if (isComposite[i]) {
                continue;
            }

            for (int j = i * i; j < LIMIT; j += i) {
                isComposite[j] = true;
            }
        }
    }

    private void dfs(String numbers, int depth) {
        if (sb.length() > 0) {
            candidateSet.add(Integer.parseInt(sb.toString()));
        }

        if (depth >= numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                dfs(numbers, depth + 1);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}