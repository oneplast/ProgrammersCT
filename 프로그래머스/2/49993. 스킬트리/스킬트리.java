import java.util.*;

class Solution {
	public int solution(String skill, String[] skill_trees) {
		Set<String> skillSet = new HashSet<>(Arrays.asList(skill.split("")));
		String[] skillOrders = skill.split("");

		int result = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			int curIdx = 0;
			boolean isPossible = true;
			for (String curSkill : skill_trees[i].split("")) {
				if (skillSet.contains(curSkill)) {
					if (!skillOrders[curIdx].equals(curSkill)) {
						isPossible = false;
						break;
					}

					curIdx++;
				}
			}

			if (isPossible) {
				result++;
			}
		}

		return result;
	}
}