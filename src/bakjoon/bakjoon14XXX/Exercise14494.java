package bakjoon.bakjoon14XXX;

import java.util.Scanner;

public class Exercise14494 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] dp = new long[n+1][m+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (dp[i-1][j] % MOD + dp[i][j-1] % MOD + dp[i-1][j-1] % MOD);
            }
        }
        System.out.println(dp[n][m] % MOD);
    }
}
