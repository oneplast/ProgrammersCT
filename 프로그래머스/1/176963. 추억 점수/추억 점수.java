import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] results = new int[photo.length];
        Map<String, Integer> scoreBoard = new HashMap<>();
        IntStream.range(0, name.length)
                .forEach(i -> scoreBoard.put(name[i], yearning[i]));

        int resultIdx = 0;
        for (String[] photoNames : photo) {
            int photoScore = 0;
            for (String photoName : photoNames) {
                photoScore += scoreBoard.getOrDefault(photoName, 0);
            }
            results[resultIdx++] = photoScore;
        }

        return results;
    }
}