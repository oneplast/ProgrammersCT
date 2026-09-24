import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scoreBoard = new HashMap<>();
        IntStream.range(0, name.length)
                .forEach(i -> scoreBoard.put(name[i], yearning[i]));

        return Arrays.stream(photo)
                .mapToInt(photoNames ->
                        Arrays.stream(photoNames)
                                .mapToInt(photoName -> scoreBoard.getOrDefault(photoName, 0))
                                .sum())
                .toArray();
    }
}