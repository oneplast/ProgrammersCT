import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        int x = 0;
        int y = k;
        List<int[]> list = new ArrayList<>();

        int n = 0;
        while (true) {
            list.add(new int[]{x, y});

            if (y == 1) {
                break;
            }

            if (y % 2 == 0) {
                y /= 2;
            } else {
                y = y * 3 + 1;
            }
            x++;
            n++;
        }

        List<Double> dp = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            int[] base = list.get(i);
            int[] vs = list.get(i - 1);

            dp.add(calculate(base, vs));
        }

        List<Double> result = new ArrayList<>();

        for (int[] range : ranges) {
            int[] xRange = getRange(range, n);
            double sum = 0;

            if (xRange[0] > xRange[1]) {
                result.add(-1.0);
                continue;
            }

            for (int i = xRange[0]; i < xRange[1]; i++) {
                sum += dp.get(i);
            }

            result.add(sum);
        }

        return result.stream().mapToDouble(a -> a).toArray();
    }

    private double calculate(int[] base, int[] vs) {
        return (base[1] + vs[1]) / (double) 2;
    }

    private int[] getRange(int[] range, int n) {
        int x1 = range[0];
        int x2 = n + range[1];

        return new int[]{x1, x2};
    }
}