class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        return new int[]{gcd, lcm(n, m, gcd)};
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
}