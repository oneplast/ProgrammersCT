import java.util.*;

class Solution {

    List<String> operList;
    boolean[] visited;
    int n;
    long max = Long.MIN_VALUE;

    public long solution(String expression) {
        Set<String> operSet = new HashSet<>();
        for (String str : expression.split("")) {
            if (str.equals("+") || str.equals("-") || str.equals("*")) {
                operSet.add(str);
            }
        }

        operList = new ArrayList<>(operSet);
        n = operList.size();
        visited = new boolean[n];

        permutation(new ArrayList<>(), expression);

        return max;
    }

    private void permutation(List<String> list, String expression) {
        if (list.size() == n) {
            max = Math.max(Math.abs(logic(list, expression)), max);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(operList.get(i));
                permutation(list, expression);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    private long logic(List<String> list, String expression) {
        List<Long> nums = new ArrayList<>();
        List<String> ops = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                nums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                ops.add(String.valueOf(c));
            } else {
                sb.append(c);
            }
        }
        nums.add(Long.parseLong(sb.toString()));

        for (String op : list) {
            for (int i = 0; i < ops.size();) {
                if (ops.get(i).equals(op)) {
                    long result = calculate(nums.get(i), nums.get(i + 1), op);
                    nums.remove(i + 1);
                    nums.set(i, result);
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }

        return nums.get(0);
    }

    private long calculate(long val1, long val2, String operation) {
        switch (operation) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            default:
                return val1 * val2;
        }
    }
}
