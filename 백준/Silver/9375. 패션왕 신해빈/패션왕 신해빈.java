import java.io.*;
import java.util.*;

public class Main {
    static int r;
    static int n;
    static Map<String, Integer> map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        r = Integer.parseInt(br.readLine());
        
        StringTokenizer token;
        int result = 1;
        String item, category;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            n = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            result = 1;
            for (int ㅓ = 0; ㅓ < n; ㅓ++) {
                token = new StringTokenizer(br.readLine());
                item = token.nextToken();
                category = token.nextToken();
                
                map.put(category, map.getOrDefault(category, 0) + 1);
            }
            
            for (int cnt : map.values()) {
                result *= (cnt + 1);
            }
            
            sb.append(result - 1).append("\n");
        }
        
        System.out.print(sb);
    }
}