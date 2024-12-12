import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        BigInteger p = BigInteger.ONE;
        for (int i = balls; i > balls - share; i--) {
            p = p.multiply(BigInteger.valueOf(i));
        }

        BigInteger r = BigInteger.ONE;
        for (int i = share; i > 0; i--) {
            r = r.multiply(BigInteger.valueOf(i));
        }

        return p.divide(r).intValue();
    }
}
