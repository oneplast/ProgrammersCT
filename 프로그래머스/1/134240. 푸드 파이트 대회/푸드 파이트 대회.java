import java.util.stream.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder preWater = new StringBuilder();
        StringBuilder postWater = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int half = food[i] / 2;

            fillStr(i, half, preWater);
            fillStr(i, half, postWater);
        }

        return preWater.append("0").append(postWater.reverse()).toString();
    }

    private void fillStr(int idx, int half, StringBuilder sb) {
        IntStream.range(0, half)
                .forEach(x -> sb.append(idx));
    }
}