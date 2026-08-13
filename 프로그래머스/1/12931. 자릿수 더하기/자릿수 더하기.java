import java.util.*;

public class Solution {
    public int solution(int n) {
        return String.valueOf(n)
                .chars()
                .map(x -> x - '0')
                .sum();
    }
}