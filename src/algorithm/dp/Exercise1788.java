package algorithm.dp;

import java.util.Scanner;

public class Exercise1788 {

    private static final long MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] dp = new long[Math.abs(num)+1];
        for (int i = 1; i <= Math.abs(num); i++) {
            dp[i] = (i < 2) ? 1 : dp[i-1]+dp[i-2];
            dp[i] %= MOD;
        }

        if (num < 0 && num % 2 == 0) {
            System.out.println(-1);
        } else if (num == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
        System.out.println(dp[Math.abs(num)]);
    }
}
