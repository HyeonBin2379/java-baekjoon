package bakjoon.bakjoon2XXX;

import java.util.Scanner;

public class Exercise2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int digits = sc.nextInt();
        long[][] dp = new long[digits+1][2];

        dp[1][0] = 0L;
        dp[1][1] = 1L;
        for (int i = 2; i < digits+1; i++) {
            dp[i][0] = dp[i-1][1] + dp[i-1][0];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[digits][0]+dp[digits][1]);
    }
}
