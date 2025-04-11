package baekjoon.baekjoon02XXX;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise2775 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] dp = new int[k+1][n+1];
            for (int i = 0; i <= k; i++) {
                if (i == 0) {
                    dp[i] = IntStream.rangeClosed(0, n).toArray();
                    continue;
                }

                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}
