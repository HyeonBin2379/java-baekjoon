package algorithm.dp;

import java.util.Scanner;

public class Exercise1904 {

    private static final int MOD = 15746;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = (i < 3) ? i : dp[i-1]+dp[i-2];
            dp[i] %= MOD;
        }
        System.out.println(dp[n]);
    }
}
