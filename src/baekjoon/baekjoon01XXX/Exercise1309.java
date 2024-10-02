package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1309 {

    private static final int MOD = 9901;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            switch (i) {
                case 1 -> dp[i] = 3;
                case 2 -> dp[i] = 7;
                default -> dp[i] = 2 * dp[i - 1] + dp[i - 2];
            }
            dp[i] %= MOD;
        }
        System.out.println(dp[n]);
    }
}
