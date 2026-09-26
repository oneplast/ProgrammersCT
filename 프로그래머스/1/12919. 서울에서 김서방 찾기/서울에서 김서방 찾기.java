import java.util.stream.*;

class Solution {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder().append("김서방은 ");
        
        IntStream.range(0, seoul.length)
                .filter(i -> seoul[i].equals("Kim"))
                .findFirst()
                .ifPresent(i -> sb.append(i).append("에 있다"));

        return sb.toString();
    }
}