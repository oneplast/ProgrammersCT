import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a, b, c, d;
    static int[] abArr, cdArr;

    public static void main(String[] args) throws IOException {
        long result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            a[i] = parse(token);
            b[i] = parse(token);
            c[i] = parse(token);
            d[i] = parse(token);
        }

        int size = n * n;
        abArr = new int[size];
        cdArr = new int[size];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                abArr[idx] = (a[i] + b[j]);
                cdArr[idx] = (c[i] + d[j]);
                idx++;
            }
        }

        Arrays.sort(abArr);
        Arrays.sort(cdArr);

        int abSum, cdSum, totalSum;
        int abIdx = 0;
        int cdIdx = size - 1;
        int abDupCnt;
        int cdDupCnt;

        while (abIdx < size && cdIdx >= 0) {
            abSum = abArr[abIdx];
            cdSum = cdArr[cdIdx];

            totalSum = abSum + cdSum;

            if (totalSum < 0) {
                abIdx++;
            } else if (totalSum > 0) {
                cdIdx--;
            } else {
                abDupCnt = 1;
                cdDupCnt = 1;
                while (abIdx + 1 < size && (abArr[abIdx] == abArr[abIdx + 1])) {
                    abDupCnt++;
                    abIdx++;
                }

                while (cdIdx - 1 >= 0 && (cdArr[cdIdx] == cdArr[cdIdx - 1])) {
                    cdDupCnt++;
                    cdIdx--;
                }

                result += (long) abDupCnt * cdDupCnt;

                abIdx++;
                cdIdx--;
            }
        }

        System.out.println(result);
    }

    public static int parse(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }
}