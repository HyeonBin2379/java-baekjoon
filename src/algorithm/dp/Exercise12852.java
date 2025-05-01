package algorithm.dp;

import java.util.Scanner;

public class Exercise12852 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        int[] pre = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+1;
            pre[i] = i-1;
            if (i % 3 == 0 && dp[i] > dp[i/3]+1) {
                dp[i] = dp[i/3]+1;
                pre[i] = i/3;
            }
            if (i % 2 == 0 && dp[i] > dp[i/2]+1) {
                dp[i] = dp[i/2]+1;
                pre[i] = i/2;
            }
        }

        System.out.println(dp[n]);
        StringBuilder sb = new StringBuilder(Integer.toString(n));
        int idx = n;
        while (pre[idx] != 0) {
            sb.append(" ").append(pre[idx]);
            idx = pre[idx];
        }
        System.out.println(sb);
    }
}
