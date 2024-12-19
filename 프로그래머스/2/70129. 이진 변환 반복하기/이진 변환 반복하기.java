class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int len = s.length();
            s = s.replace("0", "");
            int newLen = s.length();

            s = Integer.toBinaryString(newLen);
            answer[0]++;
            answer[1] += len- newLen;
        }

        return answer;
    }
}
