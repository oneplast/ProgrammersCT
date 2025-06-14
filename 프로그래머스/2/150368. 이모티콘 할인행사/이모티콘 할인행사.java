class Solution {
    int[] discountRate = new int[]{10, 20, 30, 40};
    int[] result = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(users, emoticons, new int[emoticons.length], 0);
        return result;
    }

    private void dfs(int[][] users, int[] emoticons, int[] rates, int depth) {
        if (depth == emoticons.length) {
            calculate(users, emoticons, rates);
            return;
        }

        for (int rate : discountRate) {
            rates[depth] = rate;
            dfs(users, emoticons, rates, depth + 1);
        }
    }

    private void calculate(int[][] users, int[] emoticons, int[] rates) {
        int cnt = 0;
        int totalSales = 0;

        for (int[] user : users) {
            int minRate = user[0];
            int maxPrice = user[1];
            int sum = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (rates[i] >= minRate) {
                    sum += getDiscount(emoticons[i], rates[i]);
                }
            }

            if (sum >= maxPrice) {
                ++cnt;
            } else {
                totalSales += sum;
            }
        }

        if (cnt > result[0] || (cnt == result[0] && totalSales > result[1])) {
            result[0] = cnt;
            result[1] = totalSales;
        }
    }

    private int getDiscount(int price, int discountRate) {
        return (price * (100 - discountRate)) / 100;
    }
}