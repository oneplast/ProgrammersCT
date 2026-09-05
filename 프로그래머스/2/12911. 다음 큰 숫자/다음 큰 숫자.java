class Solution {
    public int solution(int n) {
        int binaryCnt = Integer.bitCount(n);

        while (binaryCnt != Integer.bitCount(++n));

        return n;
    }
}