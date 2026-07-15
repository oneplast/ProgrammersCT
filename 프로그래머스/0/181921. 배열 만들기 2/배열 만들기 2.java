import java.util.*;
import java.util.stream.*;

class Solution {
    static final int MUL = 10;
    static final int BASE = 5;
    
    static Queue<Integer> queue = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(int l, int r) {
        queue.offer(BASE);
        
        bfs(l, r);
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        return list.stream()
            .mapToInt(x -> x)
            .toArray();
    }
    
    private void bfs(int l, int r) {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            
            if (num > r) {
                continue;
            }
            
            if (num >= l) {
                list.add(num);
            }
            
            queue.offer(num * MUL);
            queue.offer(num * MUL + BASE);
        }
        
    }
}