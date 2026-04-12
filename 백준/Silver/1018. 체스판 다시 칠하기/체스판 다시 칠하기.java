import java.io.*;
import java.util.*;

public class Main {
    static final int ROW_COL = 8;
    static int n, m;
    static int result = Integer.MAX_VALUE;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = parse(token);
        m = parse(token);

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int startRow = 0; startRow <= n - ROW_COL; startRow++) {
            for (int startCol = 0; startCol <= m - ROW_COL; startCol++) {
                int solvedW = 0;
                int solvedB = 0;
                for (int i = startRow; i < startRow + ROW_COL; i++) {
                    for (int j = startCol; j < startCol + ROW_COL; j++) {
                        solvedW += solveStartW(i, j);
                        solvedB += solveStartB(i, j);
                    }
                }
                result = Math.min(result, Math.min(solvedW, solvedB));
            }
        }

        System.out.print(result);
    }

    private static int solveStartW(int i, int j) {
        if ((i + j) % 2 == 0) {
            if (board[i][j] != 'W') {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (board[i][j] != 'B') {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private static int solveStartB(int i, int j) {
        if ((i + j) % 2 == 0) {
            if (board[i][j] != 'B') {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (board[i][j] != 'W') {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}