import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = parse(token);
        int r = parse(token);
        int c = parse(token);
        
        System.out.print(recursive(n, r, c));
    }
    
    private static int recursive(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        
        int half = 1 << (n - 1);
        int size = half * half;
        
        if (r < half && c < half) {
            return recursive(n - 1, r, c);
        } else if (r < half && c >= half) {
            return size * 1 + recursive(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return size * 2 + recursive(n - 1, r - half, c);
        } else {
            return size * 3 + recursive(n - 1, r - half, c - half);
        }
    }
    
    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}