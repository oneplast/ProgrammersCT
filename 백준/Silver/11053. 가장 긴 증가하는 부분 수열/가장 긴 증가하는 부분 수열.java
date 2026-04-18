import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int num;
        int result = 0;
        for (int i = 0; i < n; i++) {
            num = parse(token);
            
            int left = 0;
            int right = result;
            
            while (left < right) {
                int mid = (left + right) / 2;
                
                if (arr[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            arr[left] = num;
            
            if (left == result) {
                result++;
            }
        }
        
        System.out.print(result);
    }
    
    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}