import java.io.*;

public class Main {
    static int[] board;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];

        nQueen(0);

        System.out.println(cnt);
    }

    public static void nQueen(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[row] = i;

            if (isPromising(row)) {
                nQueen(row + 1);
            }
        }
    }

    public static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }

        return true;
    }
}