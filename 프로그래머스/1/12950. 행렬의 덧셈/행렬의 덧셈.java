import java.util.*;
import java.util.stream.*;

class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int row = arr1.length;
		int col = arr1[0].length;

		return IntStream.range(0, row)
			.mapToObj(i -> IntStream.range(0, col)
				.map(j -> arr1[i][j] + arr2[i][j])
				.toArray())
			.toArray(int[][]::new);
	}
}