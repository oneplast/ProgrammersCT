import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_NODE_SIZE = 10_000;
    static int[] preOrderArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp = new int[MAX_NODE_SIZE];
        int idx = 0;
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            temp[idx++] = Integer.parseInt(line);
        }

        preOrderArr = new int[idx];
        System.arraycopy(temp, 0, preOrderArr, 0, idx);

        postOrder(0, idx - 1);

        System.out.print(sb);
    }

    static void postOrder(int start, int end) {
        if (start > end) {
            return;
        }

        int root = preOrderArr[start];

        int rightStart = start + 1;
        while (rightStart <= end && preOrderArr[rightStart] < root) {
            rightStart++;
        }

        postOrder(start + 1, rightStart - 1);
        postOrder(rightStart, end);
        sb.append(root).append("\n");
    }
}