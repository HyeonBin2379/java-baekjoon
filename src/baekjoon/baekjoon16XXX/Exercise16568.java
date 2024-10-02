package baekjoon.baekjoon16XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise16568 {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] move = {1, a+1, b+1};
        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);
        dp[n] = 0;
        for (int i = n; i >= 0; i--) {
            for (int k : move) {
                if (i - k >= 0) {
                    dp[i - k] = Math.min(dp[i - k], dp[i] + 1);
                }
            }
        }
        System.out.println(dp[0]);
    }
}
