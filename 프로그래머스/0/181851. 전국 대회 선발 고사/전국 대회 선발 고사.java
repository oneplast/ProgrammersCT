import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int result = 0;
        PriorityQueue<Rank> pq = new PriorityQueue<>();
        IntStream.range(0, rank.length)
                .forEach(i -> pq.offer(new Rank(i, rank[i], attendance[i])));

        int cnt = 0;
        while (cnt < 3) {
            Rank cur = pq.poll();

            if (!cur.flag) {
                continue;
            }

            if (cnt == 0) {
                result += cur.idx;
                cnt++;
                continue;
            }

            result *= 100;
            result += cur.idx;
            cnt++;
        }

        return result;
    }
}

class Rank implements Comparable<Rank> {
    int idx;
    int rank;
    boolean flag;

    public Rank(int idx, int rank, boolean flag) {
        this.idx = idx;
        this.rank = rank;
        this.flag = flag;
    }


    @Override
    public int compareTo(Rank o) {
        return this.rank - o.rank;
    }
}
