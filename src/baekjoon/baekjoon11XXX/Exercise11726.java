package baekjoon.baekjoon11XXX;

import java.io.IOException;
import java.util.Scanner;

public class Exercise11726 {
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        sc.close();

        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
            for (int i = 3; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
        }
        System.out.println(dp[n]);
    }
}
