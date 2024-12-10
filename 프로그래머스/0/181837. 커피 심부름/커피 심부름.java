class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for (String coffee : order) {
            if (coffee.contains("americano")) {
                answer += 4500;
            } else if (coffee.contains("latte")) {
                answer += 5000;
            } else {
                answer += 4500;
            }
        }
        return answer;
    }
}