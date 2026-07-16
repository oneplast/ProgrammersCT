class Solution {
    static final int SIZE = 1000;
    
    public int solution(int[] array) {
        int[] counts = new int[SIZE];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }
        
        boolean isMulti = false;
        int max = 0, result = 0;
        for (int i = 0; i < counts.length; i++) {
            int cur = counts[i];
            if (cur > max) {
                isMulti = false;
                max = cur;
                result = i;
            } else if (cur == max) {
                isMulti = true;
            }
        }
        
        return isMulti ? -1 : result;
    }
}