class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        for (int[] query : queries) {
            StringBuilder temp = new StringBuilder();
            temp.append(sb.substring(query[0], query[1] + 1)).reverse();
            sb.replace(query[0], query[1] + 1, temp.toString());
        }

        return sb.toString();
    }
}
