package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1003 {

    private static final long[] dp = new long[41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fibonacci();

        int tc = sc.nextInt();
        while (tc-- > 0) {
            int input = sc.nextInt();
            if (input == 0) {
                System.out.println(1 + " " + 0);
            } else if (input == 1) {
                System.out.println(0 + " " + 1);
            } else {
                System.out.println(dp[input-1] + " " + dp[input]);
            }
        }
    }

    private static void fibonacci() {
        for (int i = 1; i <= 40; i++) {
            dp[i] = i == 1 ? 1 : dp[i-2]+dp[i-1];
        }
    }
}
