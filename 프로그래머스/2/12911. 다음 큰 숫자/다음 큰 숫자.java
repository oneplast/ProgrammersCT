class Solution {
    public int solution(int n) {
        int nCnt = Integer.bitCount(n);

        while (nCnt != Integer.bitCount(++n));

        return n;
    }
}
