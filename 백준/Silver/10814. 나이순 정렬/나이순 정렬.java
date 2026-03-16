import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token;

        int age;
        String name;
        PriorityQueue<Member> pq = new PriorityQueue<>((a, b) -> {
            if (a.age == b.age) {
                return a.order - b.order;
            }

            return a.age - b.age;
        });
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            age = Integer.parseInt(token.nextToken());
            name = token.nextToken();
            pq.offer(new Member(age, name, i));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Member member = pq.poll();
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        System.out.print(sb);
    }
}

class Member {
    int age;
    String name;
    int order;

    public Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }
}