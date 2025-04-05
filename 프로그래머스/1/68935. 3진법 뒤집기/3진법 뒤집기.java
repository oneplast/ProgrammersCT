class Solution {
    public int solution(int n) {
        int answer = 0;
        final int NUM = 3;
        String reverseNum = "";
        
        while(true) {
            if (n >= NUM) {
                reverseNum += n % NUM;
                n /= NUM;
            }
            else {
                reverseNum += n;
                break;
            }
        }
        
        for (int i = reverseNum.length() - 1, j = 1; i >= 0; i--) {
            answer += (reverseNum.charAt(i) - '0') * j;
            j *= NUM;
        }
        
        return answer;
    }
}