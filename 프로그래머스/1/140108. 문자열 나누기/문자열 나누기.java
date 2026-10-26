class Solution {
    public int solution(String s) {
        int result = 0;
        char[] alphas = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        char startChar = 0;
        int charCnt = 0;
        
        for (int i = 0; i < alphas.length; i++) {
            if (sb.isEmpty() && charCnt == 0) {
                startChar = alphas[i];
                charCnt = 1;
                continue;
            }
            
            if (startChar == alphas[i]) {
                charCnt++;
            } else {
                sb.append(alphas[i]);
            }
            
            if (sb.length() == charCnt) {
                sb.setLength(0);
                charCnt = 0;
                result++;
            }
        }
        
        if (!sb.isEmpty() || charCnt > 0) {
            result++;
        }
        
        return result;
    }
}