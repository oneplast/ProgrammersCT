import java.util.*;

class Solution {
	static final int LIMIT = 5;

	public int solution(String dirs) {
		Set<String> visited = new HashSet<>();
		int x = 0, y = 0;
		for (String dir : dirs.split("")) {
			int nextX = x;
			int nextY = y;

			switch (dir) {
				case "U":
					nextY--;
					break;
				case "D":
					nextY++;
					break;
				case "R":
					nextX++;
					break;
				case "L":
					nextX--;
					break;
			}

			if (nextX > LIMIT || nextX < -LIMIT || nextY > LIMIT || nextY < -LIMIT) {
				continue;
			}

			String pathTo = "" + x + y + nextX + nextY;
			String pathFrom = "" + nextX + nextY + x + y;

			if (!visited.contains(pathTo) && !visited.contains(pathFrom)) {
				visited.add(pathTo);
			}

			x = nextX;
			y = nextY;
		}

		return visited.size();
	}
}