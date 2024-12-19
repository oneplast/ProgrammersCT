import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> list = new ArrayList<>();
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        int len = num_list.length;

        switch (n) {
            case 1:
                list = IntStream.rangeClosed(0, b)
                        .boxed()
                        .map(x -> num_list[x])
                        .collect(Collectors.toList());
                break;
            case 2:
                list = IntStream.range(a, len)
                        .boxed()
                        .map(x -> num_list[x])
                        .collect(Collectors.toList());
                break;
            case 3:
                list = IntStream.rangeClosed(a, b)
                        .boxed()
                        .map(x -> num_list[x])
                        .collect(Collectors.toList());
                break;
            case 4:
                list = IntStream.iterate(a, i -> i + c)
                        .limit((b - a) / c + 1)
                        .boxed()
                        .map(x -> num_list[x])
                        .collect(Collectors.toList());
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}
