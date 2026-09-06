class Solution {
    static final int MOD = 26;

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                continue;
            }

            char base = Character.isUpperCase(c) ? 'A' : 'a';
            sb.append((char) ((c + n - base) % MOD + base));
        }

        return sb.toString();
    }
}