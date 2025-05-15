import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        List<Disk> disks = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            disks.add(new Disk(i, jobs[i][0], jobs[i][1]));
        }
        int size = disks.size();

        disks.sort(Comparator.comparingInt(a -> a.start));

        PriorityQueue<Disk> pq = new PriorityQueue<>();

        int idx = 0;
        int curTime = 0;
        int cnt = 0;
        int totalTurnAround = 0;
        while (cnt < size) {
            while (idx < size && disks.get(idx).start <= curTime) {
                pq.offer(disks.get(idx++));
            }

            if (!pq.isEmpty()) {
                Disk cur = pq.poll();
                curTime += cur.use;
                totalTurnAround += curTime - cur.start;
                cnt++;
            } else {
                curTime = disks.get(idx).start;
            }
        }

        return totalTurnAround / size;
    }

    static class Disk implements Comparable<Disk> {
        int idx;
        int start;
        int use;

        public Disk(int idx, int start, int use) {
            this.idx = idx;
            this.start = start;
            this.use = use;
        }

        @Override
        public int compareTo(Disk o) {
            if (this.use == o.use) {
                return this.start == o.start ? this.idx - o.idx : this.start - o.start;
            } else {
                return this.use - o.use;
            }
        }
    }
}