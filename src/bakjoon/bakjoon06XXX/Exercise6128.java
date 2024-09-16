package bakjoon.bakjoon06XXX;

import java.util.Scanner;

public class Exercise6128 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[5][n+1];
        dp[0][0] = 1;

        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k*k <= j; k++) {
                    dp[i][j] += dp[i-1][j-k*k];
                }
            }
        }
        System.out.println(dp[4][n]);
    }
}
