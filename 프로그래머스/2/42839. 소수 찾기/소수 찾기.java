import java.util.*;

class Solution {
    Set<Integer> set;
    boolean[] visited;
    StringBuilder sb;

    public int solution(String numbers) {
        int result = 0;
        set = new HashSet<>();
        int n = numbers.length();
        visited = new boolean[n];
        sb = new StringBuilder();

        dfs(numbers, n);

        for (int num : set) {
            if (isPrime(num)) {
                result++;
            }
        }

        return result;
    }

    private void dfs(String numbers, int n) {
        if (!sb.toString().isEmpty()) {
            set.add(Integer.parseInt(sb.toString()));
        }

        if (sb.length() >= n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                dfs(numbers, n);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}