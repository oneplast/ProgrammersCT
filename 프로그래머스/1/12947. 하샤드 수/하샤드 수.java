class Solution {
    public boolean solution(int x) {
        String strX = String.valueOf(x);

        int sum = 0;
        for (char charX : strX.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(charX));
        }

        return x % sum == 0;
    }
}
