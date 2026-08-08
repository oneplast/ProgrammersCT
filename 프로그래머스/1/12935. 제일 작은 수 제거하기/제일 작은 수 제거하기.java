import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr)
			.min().getAsInt();

		int[] results = Arrays.stream(arr)
			.filter(x -> x != min)
			.toArray();
		
		return results.length == 0 ? new int[]{-1} : results;
    }
}