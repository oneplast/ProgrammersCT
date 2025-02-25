import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> skills = Arrays.asList(skill.split(""));

        int preIdx;
        for (String skill_tree : skill_trees) {
            preIdx = 0;
            boolean isPossible = true;
            String[] splitBits = skill_tree.split("");

            for (int i = 0; i < splitBits.length; i++) {
                if (skills.contains(splitBits[i])) {
                    String preStr = skills.get(preIdx);

                    if (!skill_tree.contains(preStr)) {
                        isPossible = false;
                        break;
                    }

                    if (skill_tree.indexOf(preStr) > skill_tree.indexOf(splitBits[i])) {
                        isPossible = false;
                        break;
                    }

                    preIdx++;
                }
            }

            if (isPossible) {
                answer++;
            }
        }

        return answer;
    }
}