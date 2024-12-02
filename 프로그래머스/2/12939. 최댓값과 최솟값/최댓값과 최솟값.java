class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] numArr = new int[str.length];
        int max = Integer.parseInt(str[0]);
        int min = Integer.parseInt(str[0]);
        String answer = "";
        for (int i=0; i<str.length; i++) {
            numArr[i] = Integer.parseInt(str[i]);
            if (numArr[i]>max) {
                max = numArr[i];
            }
            if (numArr[i]<min) {
                min = numArr[i];
            }
        }
        answer += min + " " + max;
        return answer;
    }
}