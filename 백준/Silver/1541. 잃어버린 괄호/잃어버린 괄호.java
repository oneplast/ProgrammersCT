import java.io.*;

public class Main {
    static String[] minusBits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        minusBits = br.readLine().split("-");

        int firstTotal = calculate(0);

        int forRemovalTotal = 0;
        for (int i = 1; i < minusBits.length; i++) {
            forRemovalTotal += calculate(i);
        }

        System.out.print(firstTotal - forRemovalTotal);
    }

    private static int calculate(int idx) {
        String[] plusBits = minusBits[idx].split("\\+");

        int total = 0;
        for (String bit : plusBits) {
            total += Integer.parseInt(bit);
        }

        return total;
    }
}