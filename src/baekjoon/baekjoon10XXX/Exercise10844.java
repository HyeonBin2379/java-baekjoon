package baekjoon.baekjoon10XXX;

import java.util.Scanner;

public class Exercise10844 {
    private static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][10];
        sc.close();

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < n+1; i++) {
            dp[i][0] = dp[i-1][1] % MOD;
            dp[i][9] = dp[i-1][8] % MOD;
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i-1][j-1]+ dp[i-1][j+1]) % MOD;
            }
        }

        int sum = 0;
        for (int next : dp[n]) {
            sum += next;
            sum %= MOD;
        }
        System.out.println(sum);
    }
}
