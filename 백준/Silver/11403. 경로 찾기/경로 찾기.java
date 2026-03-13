import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] matrix;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token;
        
        matrix = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = parse(token);
            }
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i][k] == 1 && matrix[k][j] == 1) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j]);
                if (j < n) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}