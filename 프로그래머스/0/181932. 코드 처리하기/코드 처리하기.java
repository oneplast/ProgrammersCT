class Solution {
    public String solution(String code) {
        int mode = 0;
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            char data = code.charAt(i);
            if (data == '1') {
                mode = changeMode(mode);
            } else {
                if (mode == 0) {
                    if (i % 2 == 0) {
                        ret.append(data);
                    }
                } else {
                    if (i % 2 == 1) {
                        ret.append(data);
                    }
                }
            }
        }

        String result = ret.toString();

        return result.isEmpty() ? "EMPTY" : result;
    }

    public int changeMode(int mode) {
        return mode == 1 ? 0 : 1;
    }
}
