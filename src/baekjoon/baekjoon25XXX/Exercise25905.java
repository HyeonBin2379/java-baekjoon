package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25905 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] p = new double[10];
        for (int i = 0; i < 10; i++) {
            p[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(p);

        double start = 1;
        for (int i = 9; i > 0; i--) {
            start *= p[i]/(10-i);
        }
        System.out.printf("%.6f\n", start*Math.pow(10, 9));
    }
}
