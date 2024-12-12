import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        int M = picture.length;
        int N = picture[0].length();
        String[] answer = new String[M * k];

        int answerIdx = 0;
        for (int i = 0; i < M; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                for (int l = 0; l < k; l++) {
                    sb.append(picture[i].charAt(j));
                }
            }

            for (int j = 0; j < k; j++) {
                answer[answerIdx++] = sb.toString();
            }
        }

        return answer;
    }
}


