class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        int size = code.length();

        for (int i = 0; i < size; i++) {
            if (i % q == r) {
                sb.append(code.charAt(i));
            }
        }

        return sb.toString();
    }
}