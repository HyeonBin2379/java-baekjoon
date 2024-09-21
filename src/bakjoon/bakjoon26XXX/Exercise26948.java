package bakjoon.bakjoon26XXX;

import java.util.Scanner;

public class Exercise26948 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (i < 3) ? i : dp[i-1]+dp[i-2]+dp[i-3];
        }
        System.out.println(dp[n]);
    }
}
