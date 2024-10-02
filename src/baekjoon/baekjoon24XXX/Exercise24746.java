package baekjoon.baekjoon24XXX;

import java.util.Scanner;

public class Exercise24746 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double p = sc.nextDouble();

        double minETN = Double.MAX_VALUE;
        int optimalN = 1;

        for (int N = 2; N <= 16; N++) {
            double P = Math.pow(1 - p, N);
            double ET = 1 * P + N - N * P;
            double ETN = ET / N;

            if (ETN + 1e-9 < minETN) {
                minETN = ETN;
                optimalN = N;
            }
        }

        if (minETN + 1e-9 < optimalN)
            System.out.println(optimalN);
        else
            System.out.println(1);
    }
}
