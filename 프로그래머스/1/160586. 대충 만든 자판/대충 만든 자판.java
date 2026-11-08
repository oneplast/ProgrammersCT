import java.util.*;

class Solution {
    static final int ALPHA_SIZE = 26;

    public int[] solution(String[] keymap, String[] targets) {
        int[] dp = new int[ALPHA_SIZE];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int alphaIdx;
        char[] keyBits;
        for (String keyStr : keymap) {
            keyBits = keyStr.toCharArray();
            for (int i = 0; i < keyBits.length; i++) {
                alphaIdx = getAlphaIdx(keyBits, i);
                dp[alphaIdx] = Math.min(dp[alphaIdx], i + 1);
            }
        }

        int n = targets.length;
        int[] results = new int[n];
        int curIdx = 0;
        int cnt;
        for (String targetStr : targets) {
            keyBits = targetStr.toCharArray();
            cnt = 0;
            for (int i = 0; i < keyBits.length; i++) {
                alphaIdx = getAlphaIdx(keyBits, i);
                cnt = dp[alphaIdx] == Integer.MAX_VALUE ? -1 : cnt + dp[alphaIdx];

                if (cnt == -1) {
                    break;
                }
            }

            results[curIdx++] = cnt;
        }

        return results;
    }

    private int getAlphaIdx(char[] keyBits, int idx) {
        return keyBits[idx] - 'A';
    }
}