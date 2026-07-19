import java.util.*;
import java.util.stream.*;

class Solution {
    private static final int CACHE_HIT = 1;
    private static final int CACHE_MISS = 5;
    
    public int solution(int cacheSize, String[] cities) {
        int result = 0;
        
        if (cacheSize == 0) {
            return CACHE_MISS * cities.length;
        }
        
        String[] upperCities = Arrays.stream(cities)
            .map(String::toUpperCase)
            .toArray(String[]::new);
        
        Queue<String> queue = new ArrayDeque<>();
        for (String city : upperCities) {
            if (queue.remove(city)) {
                result += CACHE_HIT;
                queue.offer(city);
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