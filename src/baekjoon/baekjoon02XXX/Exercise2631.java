package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (num[i] > num[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        System.out.println(n-maxLen);
    }
}
