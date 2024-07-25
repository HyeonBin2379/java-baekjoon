package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14721 {

    private static long[] x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        x = new long[n];
        y = new long[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        long minSum = Long.MAX_VALUE;
        int[] answer = {0, 0};
        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                long result = getSum(a, b, n);
                if (minSum > result) {
                    minSum = result;
                    answer = new int[] {a, b};
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static long getSum(int a, int b, int n) {
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            long diff = Math.abs(y[i]-a*x[i]-b);
            sum += diff*diff;
        }
        return sum;
    }
}
