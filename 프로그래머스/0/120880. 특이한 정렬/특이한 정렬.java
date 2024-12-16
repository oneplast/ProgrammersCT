import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Rank> list = new ArrayList<>();
        IntStream.range(0, numlist.length)
                .forEach(i -> list.add(new Rank(numlist[i], Math.abs(n - numlist[i]))));

        Collections.sort(list);

        return list.stream().mapToInt(i -> i.num).toArray();
    }
}

class Rank implements Comparable<Rank> {
    int num;
    int abs;

    public Rank(int num, int abs) {
        this.num = num;
        this.abs = abs;
    }

    @Override
    public int compareTo(Rank o) {
        if (this.abs == o.abs) {
            return o.num - this.num;
        }
        return this.abs - o.abs;
    }
}
