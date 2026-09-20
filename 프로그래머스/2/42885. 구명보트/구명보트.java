import java.util.*;

class Solution {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		int result = 0;

		int left = 0;
		int right = people.length - 1;
		while (left <= right) {
			if (left == right || people[left] + people[right] > limit) {
				right--;
			} else {
				left++;
				right--;
			}

			result++;
		}

		return result;
	}
}