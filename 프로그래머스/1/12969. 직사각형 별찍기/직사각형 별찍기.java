import java.util.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        IntStream.range(0, b)
                .forEach(n -> {
                            IntStream.range(0, a)
                                    .forEach(m -> sb.append("*"));
                            sb.append("\n");
                        }
                );

        System.out.println(sb);
    }
}
