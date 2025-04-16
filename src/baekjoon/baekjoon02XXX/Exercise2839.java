package baekjoon.baekjoon02XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[5001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[5] = dp[3] = 1;

        for (int i = 6; i <= n; i++) {
            if (dp[i-3] != Integer.MAX_VALUE || dp[i-5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            }
        }
        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}
