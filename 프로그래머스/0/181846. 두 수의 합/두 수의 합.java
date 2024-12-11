import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger _a = new BigInteger(a);
        BigInteger _b = new BigInteger(b);
        return String.valueOf(_a.add(_b));
    }
}
