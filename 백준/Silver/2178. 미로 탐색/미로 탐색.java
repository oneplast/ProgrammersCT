import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] miro;
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        
        miro = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = str.charAt(j) - '0';
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            
            for (int[] dir : dirs) {
                int nextY = y + dir[0];
                int nextX = x + dir[1];
                
                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && miro[nextY][nextX] == 1) {
                    miro[nextY][nextX] = miro[y][x] + 1;
                    queue.offer(new int[]{nextY, nextX});
                }
            }
        }
        
        System.out.print(miro[n - 1][m - 1]);
    }
}