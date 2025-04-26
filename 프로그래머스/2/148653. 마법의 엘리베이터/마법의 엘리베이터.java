class Solution {
    public int solution(int storey) {
        int answer = 0;

        int remain;
        while (storey > 0) {
            remain = storey % 10;

            if (remain == 5) {
                int tempVal = storey / 10;
                int tempRemain = tempVal % 10;
                if (tempRemain >= 5) {
                    answer += remain;
                    storey = tempVal + 1;
                } else {
                    answer += remain;
                    storey = tempVal;
                }
            } else if(remain > 5) {
                answer += 10 - remain;
                storey = (storey / 10) + 1;
            } else {
                answer += remain;
                storey /= 10;
            }
        }

        return answer;
    }
}
