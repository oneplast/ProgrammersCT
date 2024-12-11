class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        String op = ineq.concat(eq);
        switch (op) {
            case ">=":
                return n >= m ? 1 : 0;
            case "<=":
                return n <= m ? 1 : 0;
            case ">!":
                return n > m ? 1 : 0;
            default:
                return n < m ? 1 : 0;
        }
    }
}
