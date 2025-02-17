class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String digitString = Integer.toString(n, k);
        return getResult(digitString, answer);
    }

    private int getResult(String digitString, int answer) {
        String[] bits = digitString.split("0");

        for (String bit : bits) {
            if (bit.isEmpty()) {
                continue;
            }
            
            long bitString = Long.parseLong(bit);
            if (isPrime(bitString)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long bitString) {
        if (bitString < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(bitString); i++) {
            if (bitString % i == 0) {
                return false;
            }
        }

        return true;
    }
}