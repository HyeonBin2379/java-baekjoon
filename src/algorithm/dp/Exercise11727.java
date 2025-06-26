package algorithm.dp;

import java.util.Scanner;

public class Exercise11727 {

    private static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                dp[i] = 1;
                continue;
            }
            dp[i] = (dp[i-1] % MOD)+(dp[i-2]*2 % MOD);
            dp[i] %= MOD;
        }
        System.out.println(dp[n]);
    }
}
