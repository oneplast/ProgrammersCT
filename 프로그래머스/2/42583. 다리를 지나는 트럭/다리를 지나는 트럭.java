import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();

        int curWeight = 0;
        for (int truckWeight : truck_weights) {
            while (true) {
                if (queue.size() == bridge_length) {
                    curWeight -= queue.poll();
                }

                if (curWeight + truckWeight <= weight) {
                    curWeight += truckWeight;
                    queue.offer(truckWeight);
                    result++;
                    break;
                } else {
                    result++;
                    queue.offer(0);
                }
            }
        }

        return result + bridge_length;
    }
}