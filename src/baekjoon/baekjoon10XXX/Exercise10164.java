package baekjoon.baekjoon10XXX;

import java.util.Scanner;

public class Exercise10164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        if (k == 0) {
            System.out.println(countPath(n, m));
            return;
        }
        int midR = (k-1)/m + 1;
        int midC = k - (midR-1)*m;
        int destR = n - (midR-1);
        int destC = m - (midC-1);
        System.out.println(countPath(midR, midC)*countPath(destR, destC));
    }

    private static int countPath(int n, int m) {
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (i == 1 && j == 1) ? 1 : dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n][m];
    }
}
