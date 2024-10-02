package baekjoon.baekjoon04XXX;

import java.util.Scanner;

public class Exercise4172 {

    private static final int MOD = (int) 1e6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dp = new int[MOD+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int sqrt = (int)(i - Math.sqrt(i));
            int log = (int)Math.log(i);
            int sin = (int)(i*Math.sin(i)*Math.sin(i));
            dp[i] = (dp[sqrt]+dp[log]+dp[sin]) % MOD;
        }
        while (true) {
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }
            System.out.println(dp[n]);
        }
    }
}
