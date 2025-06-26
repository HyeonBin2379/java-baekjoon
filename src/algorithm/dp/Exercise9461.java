package algorithm.dp;

import java.util.Scanner;

public class Exercise9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[101];
        for (int i = 1; i <= 100; i++) {
            dp[i] = (i < 3) ? 1 : dp[i-3]+dp[i-2];
        }

        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
