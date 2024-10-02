package baekjoon.baekjoon09XXX;

import java.util.Scanner;

public class Exercise9095 {
    private static final int[] cases = new int[12];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        cases[1] = 1;
        cases[2] = 2;
        cases[3] = 4;

        for (int i = 0; i < testCase; i++) {
            int number = sc.nextInt();
            for (int j = 4; j <= number; j++) {
                cases[j] = cases[j-1]+cases[j-2]+cases[j-3];
            }
            System.out.println(cases[number]);
        }
        sc.close();
    }
}
