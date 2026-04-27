import java.io.*;
import java.util.*;

public class Main {
    static boolean found;
    static int[][] board = new int[9][9];
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] box = new boolean[9][10];
    static List<int[]> empties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        for (int i = 0; i < 9; i++) {
            line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = line.charAt(j) - '0';
                board[i][j] = num;

                if (num == 0) {
                    empties.add(new int[]{i, j});
                } else {
                    row[i][num] = true;
                    col[j][num] = true;
                    box[(i / 3) * 3 + (j / 3)][num] = true;
                }
            }
        }

        dfs(0);
    }

    private static void dfs(int idx) {
        if (found) {
            return;
        }

        if (idx == empties.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }

            System.out.print(sb);
            found = true;
            return;
        }

        int rowIdx = empties.get(idx)[0];
        int colIdx = empties.get(idx)[1];
        int boxIdx = (rowIdx / 3) * 3 + (colIdx / 3);

        for (int i = 1; i <= 9; i++) {
            if (!row[rowIdx][i] && !col[colIdx][i] && !box[boxIdx][i]) {
                board[rowIdx][colIdx] = i;
                row[rowIdx][i] = true;
                col[colIdx][i] = true;
                box[boxIdx][i] = true;

                dfs(idx + 1);

                board[rowIdx][colIdx] = 0;
                row[rowIdx][i] = false;
                col[colIdx][i] = false;
                box[boxIdx][i] = false;
            }
        }
    }
}