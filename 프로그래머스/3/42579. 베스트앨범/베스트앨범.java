import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> totalMap = new TreeMap<>();
        Map<String, PriorityQueue<Song>> detailMap = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);

            detailMap.putIfAbsent(genres[i], new PriorityQueue<>());
            detailMap.get(genres[i]).offer(new Song(i, plays[i]));
        }

        totalMap = totalMap.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> newVal,
                        LinkedHashMap::new
                ));

        int cnt = 0;
        for (String key : totalMap.keySet()) {
            while (cnt < 2) {
                if (detailMap.get(key).isEmpty()) {
                    break;
                }
                
                result.add(detailMap.get(key).poll().idx);
                cnt++;
            }
            cnt = 0;
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}

class Song implements Comparable<Song> {
    int idx;
    int play;

    public Song(int idx, int play) {
        this.idx = idx;
        this.play = play;
    }

    @Override
    public int compareTo(Song o) {
        if (this.play == o.play) {
            return this.idx - o.idx;
        }

        return o.play - this.play;
    }
}