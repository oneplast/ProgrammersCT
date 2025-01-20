import java.util.*;

class Solution {
    private static final int CACHE_HIT = 1;
    private static final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        int result = 0;
        Queue<String> queue = new LinkedList<>();

        if (cacheSize == 0) {
            return CACHE_MISS * cities.length;
        }

        for (String city : cities) {
            Optional<String> opStr = queue.stream().filter(str -> str.equalsIgnoreCase(city)).findFirst();

            if (opStr.isPresent()) {
                queue.remove(opStr.get());
                queue.offer(city);
                result += CACHE_HIT;
                continue;
            }

            if (queue.size() < cacheSize) {
                queue.offer(city);
            } else {
                queue.poll();
                queue.offer(city);
            }

            result += CACHE_MISS;
        }

        return result;
    }
}