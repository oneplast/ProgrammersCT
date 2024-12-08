import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int[] arr = IntStream.rangeClosed(1, number).map(x -> {
            int cnt = 0;
            for (int i = 1; i * i <= x; i++) {
                if (i * i == x) cnt++;
                else if (x % i == 0) cnt += 2;
            }

            return cnt;
        }).toArray();

        return Arrays.stream(arr).map(x -> {
            if (x >limit) x = power;
            return x;
        }).sum();
    }
}