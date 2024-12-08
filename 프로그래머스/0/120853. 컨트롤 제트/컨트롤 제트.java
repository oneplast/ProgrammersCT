class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] splits = s.split(" ");

        for (int i = 0; i < splits.length - 1; i++) {
            if (splits[i + 1].equals("Z") || splits[i].equals("Z")) {
                continue;
            }

            answer += Integer.parseInt(splits[i]);
        }

        if (!splits[splits.length - 1].equals("Z")) {
            answer += Integer.parseInt(splits[splits.length - 1]);
        }

        return answer;
    }
}