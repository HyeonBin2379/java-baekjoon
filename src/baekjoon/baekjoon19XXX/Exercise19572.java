package baekjoon.baekjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise19572 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double sum = Arrays.stream(num).sum()/2.0;
        double[] result = new double[3];
        for (int i = 0; i < 3; i++) {
            result[i] = sum-num[2-i];
            if (result[i] <= 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
        System.out.printf("%.1f %.1f %.1f\n", result[0], result[1], result[2]);
    }
}
