package baekjoon.baekjoon11XXX;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise11057 {

    private static final int MOD = 10007;
    private static final int[][] dp = new int[1001][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        IntStream.rangeClosed(0, 9).forEach(idx -> dp[1][idx] = 1);
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= MOD;
            }
        }
        System.out.println(IntStream.rangeClosed(0, 9).map(idx -> dp[n][idx]).sum() % MOD);
    }
}
