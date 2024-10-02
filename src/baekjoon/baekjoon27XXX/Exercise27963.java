package baekjoon.baekjoon27XXX;

import java.util.Scanner;

public class Exercise27963 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        int x = sc.nextInt();

        int max = Math.max(d1, d2);
        int min = Math.min(d1, d2);
        double result = 100.0*min*max/(x*min + (100-x)*max);
        System.out.printf("%.6f\n", result);
    }
}
