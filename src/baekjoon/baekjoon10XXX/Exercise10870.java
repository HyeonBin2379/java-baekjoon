package baekjoon.baekjoon10XXX;

import java.util.Scanner;

public class Exercise10870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i == 1 ? 1 : dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
