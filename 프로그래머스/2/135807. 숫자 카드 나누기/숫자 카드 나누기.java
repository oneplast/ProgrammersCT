class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        if (arrayA.length > 1) {
            for (int i = 1; i < arrayA.length; i++) {
                gcdA = gcd(gcdA, arrayA[i]);
            }
        }

        if (arrayB.length > 1) {
            for (int i = 1; i < arrayB.length; i++) {
                gcdB = gcd(gcdB, arrayB[i]);
            }
        }

        if (gcdA > 1) {
            for (int b : arrayB) {
                if (b % gcdA == 0) {
                    gcdA = 0;
                    break;
                }
            }
        }

        if (gcdB > 1) {
            for (int a : arrayA) {
                if (a % gcdB == 0) {
                    gcdB = 0;
                    break;
                }
            }
        }

        return gcdA > 1 ? Math.max(gcdA, gcdB) : gcdB > 1 ? gcdB : 0;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
