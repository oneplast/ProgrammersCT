class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int n = attacks.length;
        int heal = bandage[1];
        int bonus = bandage[2];
        int curHealth = health;
        int sequenceHeal = 0;
        int curIdx = 0;

        for (int i = 1; i <= attacks[n - 1][0]; i++) {
            if (i == attacks[curIdx][0]) {
                sequenceHeal = 0;
                curHealth -= attacks[curIdx][1];

                if (curHealth <= 0) {
                    return -1;
                }

                ++curIdx;
                continue;
            }

            ++sequenceHeal;
            curHealth += heal;

            if (sequenceHeal == bandage[0]) {
                sequenceHeal = 0;
                curHealth += bonus;
            }

            if (curHealth > health) {
                curHealth = health;
            }
        }

        return curHealth;
    }
}