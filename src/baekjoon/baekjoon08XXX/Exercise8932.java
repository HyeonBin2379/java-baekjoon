package baekjoon.baekjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise8932 {
    private static final double[] a = {9.23076, 1.84523, 56.0211, 4.99087, 0.188807, 15.9803, 0.11193};
    private static final double[] b = {26.7, 75, 1.5, 42.5, 210, 3.8, 254};
    private static final double[] c = {1.835, 1.348, 1.05, 1.81, 1.41, 1.04, 1.88};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] record = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for (int j = 0; j < 7; j++) {
                if (j % 3 == 0) {
                    sum += (int) (a[j] * Math.pow(b[j]-record[j], c[j]));
                } else {
                    sum += (int) (a[j] * Math.pow(record[j]-b[j], c[j]));
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
