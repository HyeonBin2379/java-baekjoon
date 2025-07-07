package algorithm.dp;

import java.util.Scanner;

public class Exercise2193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = (i < 3) ? 1 : dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
